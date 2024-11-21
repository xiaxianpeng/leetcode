#!/bin/bash

# 配置文件路径
CONFIG_FILE="src/main/resources/folder-mapping.properties"

# 获取当前时间并格式化为时间戳
get_current_timestamp() {
    date "+%Y-%m-%d %H:%M:%S"
}

# 同步源目录到目标目录
perform_sync() {
    local source_dir="$1"
    local target_dir="$2"

    echo "$(get_current_timestamp) - Ensuring target directory exists: $target_dir"
    mkdir -p "$target_dir"

    echo "$(get_current_timestamp) - Synchronizing files from $source_dir to $target_dir..."
    rsync -av --delete "$source_dir/" "$target_dir/"

    if [ $? -eq 0 ]; then
        echo "$(get_current_timestamp) - Synchronization complete from $source_dir to $target_dir"
    else
        echo "$(get_current_timestamp) - Synchronization failed for $source_dir to $target_dir"
    fi
}

# 修改 Java 文件中的包名
update_package_names() {
    local source_dir="$1"
    local target_dir="$2"

    # 从路径中提取包名
    local source_package=$(echo "$source_dir" | sed 's/src\/main\/java\///' | sed 's/\//\./g')
    local target_package=$(echo "$target_dir" | sed 's/src\/main\/java\///' | sed 's/\//\./g')

    echo "$(get_current_timestamp) - Updating package names from $source_package to $target_package in $target_dir..."
    find "$target_dir" -name "*.java" -exec sed -i.bak "s/package $source_package;/package $target_package;/g" {} \;

    if [ $? -eq 0 ]; then
        echo "$(get_current_timestamp) - Package name update complete in $target_dir"
        find "$target_dir" -name "*.java.bak" -delete  # 删除备份文件
    else
        echo "$(get_current_timestamp) - Package name update failed in $target_dir"
    fi
}

# 监听源目录的文件变动并执行同步和包名更新
monitor_and_sync() {
    local source_dir="$1"
    local target_dir="$2"

    fswatch -o -r "$source_dir" | while read -r event; do
        echo "$(get_current_timestamp) - Change detected in $source_dir, synchronizing files and updating package names..."
        perform_sync "$source_dir" "$target_dir"
        update_package_names "$source_dir" "$target_dir"
    done &
}

# 读取配置文件并启动文件监控
if [ ! -f "$CONFIG_FILE" ]; then
    echo "$(get_current_timestamp) - Configuration file not found: $CONFIG_FILE"
    exit 1
fi

while IFS='=' read -r source_dir target_dir; do
    # 跳过空行和注释行
    if [[ -z "$source_dir" || "$source_dir" =~ ^#.* ]]; then
        continue
    fi

    echo "$(get_current_timestamp) - Mapping source: $source_dir to target: $target_dir"
    monitor_and_sync "$source_dir" "$target_dir"
done < "$CONFIG_FILE"

# 等待所有后台进程完成
wait