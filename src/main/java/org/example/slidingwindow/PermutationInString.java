package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xianpeng.xia
 * on 2022/4/20 5:02 PM
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
     * 滑动窗口
     * 由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
     * 窗口收缩条件是：
     * 1、字符个数相等时
     * 2、返回true的条件是：valid == need.size()
     * 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-kylin-x-ym50/
     */
    public static boolean checkInclusion(String s1, String s2) {
        // 当前窗口中各字符的计数
        Map<Character, Integer> window = new HashMap<>();
        // s1中各字符所需的计数
        Map<Character, Integer> need = new HashMap<>();
        // s1 字符个数记录到need中
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        System.out.println("need = " + need);
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                //  判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        // 移除了一个有效字符，所以减少有效计数
                        valid--;
                    }
                    // 更新窗口中字符 d 的计数
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
