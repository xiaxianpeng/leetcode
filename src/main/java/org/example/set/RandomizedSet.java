package org.example.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * 示例：
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * 变长数组 + 哈希表
 */
public class RandomizedSet {

    /**
     * 存储集合中的元素。
     */
    List<Integer> nums;
    /**
     * 键为元素值，值为该元素在 nums 中的索引位置
     */
    Map<Integer, Integer> indices;
    /**
     * 用于生成随机数
     */
    Random random;

    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.indices = new HashMap<>();
        this.random = new Random();
    }

    /**
     * 插入一个元素，如果元素已存在返回false
     */
    public boolean insert(int val) {
        // 检查值是否存在，存在则返回 false
        if (indices.containsKey(val)) {
            return false;
        }
        // 在数组和映射表中插入值
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    /**
     * 删除一个元素，如果元素存在返回true
     */
    public boolean remove(int val) {
        // 检查值是否存在，不存在则返回 false
        if (!indices.containsKey(val)) {
            return false;
        }

        // 获取要删除值的索引
        int index = indices.get(val);

        // 将数组最后一个元素移到被删除元素的位置，并更新映射
        int lastVal = nums.get(nums.size() - 1);
        nums.set(index, lastVal);
        indices.put(lastVal, index);

        // 删除数组最后一个元素和映射中的要删除的值
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    /**
     * 获取一个随机元素
     */
    public int getRandom() {
        // 生成一个随机索引，并返回该索引对应的值
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 或 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2

    }
}
