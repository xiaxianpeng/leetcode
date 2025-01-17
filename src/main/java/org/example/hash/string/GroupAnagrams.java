package org.example.hash.string;

import java.util.ArrayList;
import java.util.Arrays;
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
     * 算法思路:
     * 通过对每个单词的字符排序，找到所有字母异位词的分组
     * 排序后的单词作为键，所有异位词组成一个值的集合
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 如果输入为空，返回空列表
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> angramsMap = new HashMap<>(); // 用来存储分组的结果

        // 遍历每个字符串
        for (String str : strs) {
            // 将字符串转为字符数组并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            // 将排序后的字符数组转为字符串，作为键
            String key = new String(charArray);

            // 如果哈希表中不存在该键，先初始化一个新的列表
            if (angramsMap.get(key) == null) {
                angramsMap.put(key, new ArrayList<>());
            }

            // 将原始字符串添加到对应的分组中
            angramsMap.get(key).add(str);
        }

        // 返回哈希表中的所有值，即字母异位词的分组
        return new ArrayList<>(angramsMap.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        System.out.println(groupAnagrams);
    }
}
