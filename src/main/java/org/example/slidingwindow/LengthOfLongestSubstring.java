package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xianpeng.xia
 * on 2022/4/20 8:38 PM
 * <p>
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 记录出现频率
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            while (frequency.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                frequency.put(d, frequency.getOrDefault(d, 0) - 1);
            }

            // 更新最大长度
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
