package org.example.string;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1
 * Created on 2024/12/5 10:08
 */
public class StrStr {

    /**
     * 找出字符串中第一个匹配项的下标
     * 算法思路：
     * 1. 遍历 haystack 字符串，以每个字符作为起始位置尝试匹配 needle。
     * 2. 如果所有字符都匹配，返回起始位置；否则继续遍历。
     * 3. 如果遍历结束未找到匹配项，返回 -1。
     *
     * @param haystack 主字符串
     * @param needle   子字符串
     * @return 子字符串在主字符串中第一次出现的起始索引，如果不存在则返回 -1
     */
    public static int strStr(String haystack, String needle) {

        // 特殊情况处理：空 needle 总是匹配，返回 0
        if (needle.isEmpty()) {
            return 0;
        }

        // 遍历 haystack ，尝试匹配 needle
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int hayIndex = i;
            int needleIndex = 0;

            // 比较当前起点是否完全匹配 needle
            while (needleIndex < needle.length() && haystack.charAt(hayIndex) == needle.charAt(needleIndex)) {
                hayIndex++;
                needleIndex++;
            }

            // 如果匹配完成，返回当前起点
            if (needleIndex == needle.length()) {
                return i;
            }
        }

        // 如果未找到匹配项，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
