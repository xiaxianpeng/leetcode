package org.example.string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * Created on 2024/12/4 23:52
 */
public class LongestCommonPrefix {

    /**
     * 通过纵向扫描的方式查找字符串数组中的最长公共前缀
     *
     * @param strs 字符串数组
     * @return 返回最长公共前缀
     * 算法思路：
     * 1. 假设第一个字符串是公共前缀
     * 2. 依次与数组中其他字符串比较，缩短公共前缀直到匹配
     * 3. 如果在任何一步公共前缀为空，直接返回空字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        // 如果输入数组为空，返回空字符串
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 假设第一个字符串是公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            // 当当前字符串不以当前公共前缀为开头时，逐步缩短公共前缀
            while (!current.startsWith(prefix)) {
                // 缩短前缀，每次去掉最后一个字符进行匹配
                prefix = prefix.substring(0, prefix.length() - 1);

                // 如果公共前缀为空，表示没有公共前缀，返回空字符串
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // 返回找到的最长公共前缀
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2));
    }
}
