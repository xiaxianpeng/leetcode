package org.example.string.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * https://leetcode.cn/problems/permutation-in-string/description/
 */
public class PermutationInString {

    /**
     * 判断 s2 是否包含 s1 的排列
     * 核心思路：使用滑动窗口法，统计 s1 中字符频率并与 s2 中当前窗口的字符频率进行比较。
     * 如果窗口内的字符频率与 s1 完全一致，则返回 true。
     *
     * @param s1 字符串 s1，目标字符串的排列
     * @param s2 字符串 s2，检查的源字符串
     * @return 如果 s2 包含 s1 的排列，返回 true；否则返回 false
     */
    public static boolean checkInclusion(String s1, String s2) {
        // 如果 s1 比 s2 长，直接返回 false，因为 s2 不可能包含 s1 的任何排列
        if (s1.length() > s2.length()) {
            return false;
        }

        // window 哈希表记录当前检查的窗口中每个字符的实际出现次数
        Map<Character, Integer> window = new HashMap<>();
        // need 哈希表记录 s1 中每个字符的期望出现次数
        Map<Character, Integer> need = new HashMap<>();
        // 初始化 need 哈希表，将 s1 字符个数记录到need中
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // left 和 right 分别代表滑动窗口的左右边界指针。
        int left = 0;
        int right = 0;
        // 用来记录当前窗口中符合 s1 字符频率的字符数
        int valid = 0;

        // 滑动窗口
        while (right < s2.length()) {
            // 移动右指针，扩大窗口
            // c 是进入窗口的字符
            char c = s2.charAt(right);
            right++; // 扩大窗口

            // 更新窗口中字符频率
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口中的字符数量符合 s1 中的字符数量，valid 增加
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 当窗口大小等于 s1 的长度时，开始收缩左边界
            while (right - left == s1.length()) {
                // 如果窗口内有效字符计数等于 need 中字符种类数，说明找到了合法排列
                if (valid == need.size()) {
                    return true;
                }

                // 移动左指针，收缩窗口
                // d 是离开窗口的字符
                char d = s2.charAt(left);
                left++;// 缩小窗口

                // 更新窗口字符频率
                if (need.containsKey(d)) {
                    // 如果窗口中的字符数量符合要求，valid 减少
                    if (window.get(d).equals(need.get(d))) {
                        // 移除了一个有效字符，所以减少有效计数
                        valid--;
                    }
                    // 更新窗口中字符 d 的计数
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        // 如果没有找到符合的子串，返回 false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
