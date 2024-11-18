package org.example.string.hashtable;

import java.util.Arrays;

/**
 * Created on 2024/11/18 10:37
 */
public class CloseStrings {

    /**
     * 使用字符频次与字符集合判断两个字符串是否接近。
     * 核心思路：
     * 1. 两字符串包含的字符集合必须相同（操作 2 的必要条件）。
     * 2. 两字符串字符的频次分布必须相同（操作 1 的必要条件）。
     * 时间复杂度：O(n + m)，其中 n 和 m 是两个字符串的长度。
     * 空间复杂度：O(1)，只使用固定大小的数组。
     */
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        // 用数组记录每个字符的频次
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // 用数组记录每个字符串中的字符集合
        boolean[] exist1 = new boolean[26];
        boolean[] exist2 = new boolean[26];

        // 遍历第一个字符串
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
            exist1[c - 'a'] = true;
        }

        // 遍历第二个字符串
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
            exist2[c - 'a'] = true;
        }

        // 字符集合必须相同
        if (!Arrays.equals(exist1, exist2)) {
            return false;
        }

        // 字符频次分布必须相同
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca")); // 输出：true
        System.out.println(closeStrings("a", "aa"));    // 输出：false
        System.out.println(closeStrings("cabbba", "abbccc")); // 输出：true
    }
}
