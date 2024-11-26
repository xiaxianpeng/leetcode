package org.example.dp.string;

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
     * 核心思路：动态规划。
     * 定义 dp[i] 表示字符串 s 从 0 到 i-1 的子串是否可以被拆分。
     * 初始化 dp[0] 为 true，表示空字符串可以被拆分。
     * 对于每一个位置 i，检查从 0 到 i 的子串是否包含字典中的单词，若是，则更新 dp[i]。
     *
     * @param s        待拆分的字符串
     * @param wordDict 单词字典列表
     * @return 字符串是否可以被拆分为字典中的单词
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 将列表转为set以提高查找速度
        Set<String> wordDictSet = new HashSet<>(wordDict);

        // 动态规划数组，dp[i] 表示 s 的前 i 个字符是否可以被拆分
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true; // 空串可以被拆分

        // 遍历字符串的每个位置
        for (int i = 1; i <= s.length(); i++) {

            // 如果前j个字符可以被拆分，且j到i的子串在字典中
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;// 更新 dp[i]
                    System.out.println("Substring to index " + i + " is valid with words: " + s.substring(j, i));
                    break;// 结束内层循环
                }
            }
        }

        // 返回整个字符串能否被拆分
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("Can 'leetcode' be segmented? " + wordBreak("leetcode", Arrays.asList("leet", "code"))); // 输出: true

        System.out.println("Can 'applepenapple' be segmented? " + wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // 输出: true

        System.out.println("Can 'catsandog' be segmented? " + wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // 输出: false
    }
}
