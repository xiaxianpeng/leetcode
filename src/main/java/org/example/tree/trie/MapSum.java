package org.example.tree.trie;

import java.util.TreeMap;

/**
 * 677. 键值映射
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 * 实现一个 MapSum 类：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
 * 如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * 示例 1：
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // 返回 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // 返回 5 (apple + app = 3 + 2 = 5)
 */
public class MapSum {

    // 前缀树节点类
    private class TireNode {

        // 当前节点的值
        private int value;
        // 子节点映射（用于存储下一个字符）
        private TreeMap<Character, TireNode> children;

        public TireNode(int value) {
            this.value = value;
            this.children = new TreeMap<>();
        }

        public TireNode() {
            this(0);// 默认值为0
        }
    }

    /**
     * 前缀树的根节点
     */
    private TireNode root;

    /**
     * 初始化 MapSum 对象
     */
    public MapSum() {
        this.root = new TireNode();
    }

    /**
     * 插入键值对。如果键已存在，则覆盖旧值。
     *
     * @param word  插入的键
     * @param value 插入的值
     */
    public void insert(String word, int value) {
        TireNode current = root;
        // 遍历字符串的每个字符
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 如果当前字符的子节点不存在，创建新的节点
            if (current.children.get(c) == null) {
                current.children.put(c, new TireNode());
            }
            // 继续深入到子节点
            current = current.children.get(c);
        }
        // 设置节点的值为插入的值
        current.value = value;
    }

    /**
     * 返回所有以给定前缀开头的键的值的总和。
     *
     * @param prefix 前缀字符串
     * @return 所有匹配键的值的总和
     */
    public int sum(String prefix) {
        TireNode current = root;
        // 找到前缀对应的最后一个节点
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // 如果当前字符的子节点不存在，则返回 0
            if (current.children.get(c) == null) {
                return 0;
            }
            // 移动到子节点
            current = current.children.get(c);
        }
        // 从前缀节点开始，递归计算值的总和
        return sumFromNode(current);
    }

    /**
     * 从当前节点递归计算所有子节点的值总和。
     *
     * @param node 当前节点
     * @return 子树的值总和
     */
    private int sumFromNode(TireNode node) {
        int total = node.value;// 当前节点的值
        // 遍历所有子节点，递归累加值
        for (char c : node.children.keySet()) {
            total += sumFromNode(node.children.get(c));
        }
        return total;
    }

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }
}
