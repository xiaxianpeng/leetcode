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
public class KMP {

    /**
     * @param s 原串
     * @param p 匹配串
     * @return p在s中的index
     * https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
     */
    public static int indexOf(String s, String p) {
        if (s.isEmpty()) {
            return 0;
        }
        // 分别读取原串和匹配串的长度
        int n = s.length(), m = p.length();
        // 原串和匹配串都加空格，使其下标从1开始
        s = " " + s;
        p = " " + p;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        // 构建next数组，数组长度为匹配串的长度
        int[] next = new int[m + 1];

        // 构造过程从1=2，j=0开始，i小于等于匹配串长度
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next[j]
            while (j > 0 && ss[i] != pp[j + 1]) {
                j = next[j];
            }
            // 如果匹配成功的话，j++
            if (pp[i] == pp[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        // 匹配过程，i=1，j=0开始，i小于等于原串长度
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功，j = next[j]
            while (j > 0 && ss[i] != pp[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让j++，结束本次循环后i++
            if (ss[i] == pp[j + 1]) {
                j++;
            }
            //  整段匹配成功，直接返回下标
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int index = indexOf(haystack, needle);
        System.out.println(index);
    }
}
