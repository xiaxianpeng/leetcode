package org.example.slidingwindow.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/11 11:48
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        // window 记录当前滑动窗口中每个字符的出现次数。
        Map<Character, Integer> window = new HashMap<>();
        // need 记录字符串 t 中每个字符需要出现的次数。
        Map<Character, Integer> need = new HashMap<>();
        // 初始化 need 映射，记录目标字符串 t 中每个字符的计数。
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // left 和 right 表示滑动窗口的左右边界 【left ，right），初始都指向字符串 s 的第一个元素位置。
        int left = 0;
        int right = 0;
        //valid表示是否满足了t中的字符，不算重复的
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度。起始索引初始化为 0，长度初始化为一个不可能的大值 Integer.MAX_VALUE。
        int start = 0;
        int len = Integer.MAX_VALUE;
        // 开始滑动窗口的操作，right 不断向右移动，直到 s 的末尾
        while (right < s.length()) {
            // c 是将要移入窗口的字符。
            char c = s.charAt(right);
            // 右移窗口的右边界。
            right++;
            // 如果 c 是 need 中记录的字符，更新 window 计数
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 当窗口中的某个字符数量满足 need 要求时，增加 valid
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩，即检查当前窗口是否涵盖了所有 t 的字符
            while (valid == need.size()) {
                // 检查当前窗口的大小是否比之前的最小子串还小
                if (right - left < len) {
                    // 更新子串的起始位置
                    start = left;
                    // 更新子串的长度
                    len = right - left;
                }
                // d 是即将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;
                // 如果 d 是 need 中记录的字符，更新 window 数量，可能需要更新 valid
                if (need.containsKey(d)) {
                    // 只有当 d 的数量严格等于 need 中的数量时，valid 才减少
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    // 减少 d 字符的数量
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 根据 len 的值判断是否找到了符合条件的子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println("min window: " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("min window: " + minWindow("a", "a"));
        System.out.println("min window: " + minWindow("a", "aa"));
    }
}
