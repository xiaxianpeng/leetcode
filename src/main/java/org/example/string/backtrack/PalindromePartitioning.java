package org.example.string.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 * 。返回 s 所有可能的分割方案。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * Created on 2024/11/25 15:18
 */
public class PalindromePartitioning {

    /**
     * 方法：分割字符串，使每个子串都是回文串
     * 核心策略：使用回溯算法逐步构建回文串分割方案，递归探索所有可能的分割路径。
     *
     * @param s 输入字符串
     * @return 所有可能的回文分割方案
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), results);
        return results;
    }

    /**
     * 回溯方法：递归构建所有可能的回文分割方案
     *
     * @param s       输入字符串
     * @param start   当前分割的起始位置
     * @param current 当前分割路径
     * @param results 存储所有分割方案的结果列表
     */
    private static void backtrack(String s, int start, List<String> current, List<List<String>> results) {
        // 如果起始位置等于字符串长度，说明找到了一种分割方案
        if (start == s.length()) {
            results.add(new ArrayList<>(current));// 将当前路径添加到结果中
            System.out.println("找到分割方案: " + current);
            return;
        }

        // 从起始位置开始，尝试分割字符串
        for (int i = start; i < s.length(); i++) {
            // 如果当前子串是回文串，则继续探索
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));// 将回文子串加入路径
                System.out.println("添加回文子串: " + s.substring(start, i + 1));

                // 递归探索剩余部分
                backtrack(s, i + 1, current, results);

                // 回溯，移除最后一个加入的子串
                current.remove(current.size() - 1);
                System.out.println("回溯，移除子串: " + s.substring(start, i + 1));
            }
        }
    }

    /**
     * 辅助方法：判断字符串的某个子串是否是回文串
     *
     * @param s     输入字符串
     * @param left  子串的左边界
     * @param right 子串的右边界
     * @return 如果子串是回文串，返回 true；否则返回 false
     */
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;// 如果左右字符不相等，则不是回文
            }
            left++;
            right--;
        }
        return true;// 如果通过检查，则是回文
    }

    public static void main(String[] args) {
        List<List<String>> partition = partition("aab");
        System.out.println("所有可能的分割方案: " + partition);
    }

}
