package org.example.string;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/10 9:05 PM
 *
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class PalindromePartitioning {

    /**
     * @param s s
     * @return 分割回文串
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return ans;
        }

        Deque<String> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, len, stack, ans);
        return ans;
    }

    /**
     * @param chars chars
     * @param index 起始位置
     * @param len 字符串的长度
     * @param path 记录从根节点到叶子节点的位置
     * @param ans 记录所有结果
     */
    private static void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> ans) {
        if (index == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!checkPalindrome(chars, index, i)) {
                continue;
            }
            path.addLast(new String(chars, index, i + 1 - index));
            dfs(chars, i + 1, len, path, ans);
            path.removeLast();
        }
    }

    /**
     * @param chars chars
     * @param left 左边界
     * @param right 右边界
     * @return 是否是回文
     */
    private static boolean checkPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }
}
