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
     *
     * @param strs 输入字符串数组
     * @return 按字母异位词分组的结果列表
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ans = new HashMap<>();

        for (String str : strs) {
            // 统计字符出现次数
            int[] chars = new int[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }

            // 将字符计数数组转换为唯一的字符串键
            StringBuffer keyBuffer = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                keyBuffer.append("#").append(chars[i]);
            }
            String key = keyBuffer.toString();

            // 将当前字符串加入对应分组
            ans.computeIfAbsent(key, k -> new ArrayList<>()).add(str);// key不存在则调用new ArrayList
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        System.out.println(groupAnagrams);
    }
}
