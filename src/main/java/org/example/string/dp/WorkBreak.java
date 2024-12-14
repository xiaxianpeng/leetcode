package org.example.string.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WorkBreak {

    /**
     * 判断字符串 s 是否可以被拆分为字典中单词的组合。
     *
     * @param s        待拆分的字符串
     * @param wordDict 单词字典列表
     * @return 字符串是否可以被拆分为字典中的单词
     * 算法思路:
     * 使用动态规划解决，定义一个布尔数组dp，其长度为s.length+1。
     * dp[i]表示s[0...i-1]这个子串是否可以用字典中的单词拼接而成。
     * dp[0] = true，表示空串可以被拆分。
     * 遍历字符串，对于每个位置i，再从0到i的每个位置j切分，
     * 如果dp[j]为true，且s[j...i-1]这个子串存在于字典中，则将dp[i]置于true。
     * 若最终dp[s.length]为true，则说明整个字符串可以被字典单词拼出。
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 使用set加速字典查询
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp数组，长度为s长度+1，用来表示子串能否由字典构成
        boolean[] dp = new boolean[s.length() + 1];
        // 空串可以由字典构成(相当于不取任何单词)
        dp[0] = true;

        System.out.println("初始化dp数组:" + Arrays.toString(dp));

        // 外层循环i表示子串的结束位置(不包含)
        // 即dp[i]表示s[0...i-1]可否被拆分
        for (int i = 1; i <= s.length(); i++) {
            System.out.println("检查子串 s[0:" + (i - 1) + "] 是否可由字典拼出");
            // 内层循环j用来分割子串s[0...i-1]为[0...j-1]和[j...i-1]
            for (int j = 0; j < i; j++) {
                // 如果dp[j]为true，说明[0...j-1]可由字典拼出
                // 此时只要s[j...i-1]这部分也在字典中，那么dp[i]可设置为true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    System.out.println("找到匹配：s[" + j + ":" + (i - 1) + "] = " + s.substring(j, i) + " 在字典中，且dp[" + j + "] = true");
                    dp[i] = true;
                    break;//已找到可行拆分，跳出内层循环
                }
            }
            System.out.println("dp[" + i + "] = " + dp[i]);
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = wordBreak(s, wordDict);
        System.out.println("是否可以由字典拼出：" + result);
    }
}
