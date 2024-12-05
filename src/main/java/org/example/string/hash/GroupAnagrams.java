package org.example.string.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class GroupAnagrams {

    /**
     * 使用字符计数法对字母异位词进行分组
     * 算法思路：
     * - 对于每个字符串，我们统计其中每个字母的频次。
     * - 将频次数组作为键（key），使用 HashMap 来分组。
     * - 相同字母频次的字符串会映射到同一个 key，从而分到同一组。
     *
     * @param strs 输入字符串数组
     * @return 按字母异位词分组的结果列表
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();// 如果输入为空，返回空列表
        }

        Map<String, List<String>> ans = new HashMap<>(); // 用来存储分组的结果

        // 遍历每个字符串
        for (String str : strs) {
            // 创建一个长度为 26 的数组，用于统计每个字符出现的次数
            int[] chars = new int[26];// 只有小写字母，所以数组大小为 26
            for (char c : str.toCharArray()) {
                chars[c - 'a']++; // 通过字符 'a' 的 ASCII 值来找到字符的对应位置
            }

            // 将字符计数数组转换为唯一的字符串作为键
            StringBuffer keyBuffer = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                keyBuffer.append("#").append(chars[i]);// 拼接字符频次形成一个字符串
            }
            String key = keyBuffer.toString(); // 将字符频次数组转为字符串作为唯一键

            // 使用 HashMap 分组，将具有相同字符频次的字符串归为一组
            ans.computeIfAbsent(key, k -> new ArrayList<>()).add(str);// 如果key不存在，创建新列表
        }

        // 返回 HashMap 中的所有值，即字母异位词分组的结果
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        System.out.println(groupAnagrams);
    }
}
