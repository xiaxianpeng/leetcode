package org.example.hash.string;

import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
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
