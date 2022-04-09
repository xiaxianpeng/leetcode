package org.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xianpeng.xia
 * on 2022/4/9 12:48 PM
 * 字母异位词分组
 *
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<>();
        // 存放字母出现的次数
        int[] chars = new int[26];
        for (String str : strs) {
            // 填充0
            Arrays.fill(chars, 0);
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                sb.append("#").append(chars[i]);
            }
            //
            String key = sb.toString();
            if (ans.get(key) == null) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        System.out.println(groupAnagrams);
    }
}
