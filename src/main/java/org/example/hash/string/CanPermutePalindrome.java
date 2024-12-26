package org.example.hash.string;

import java.util.HashMap;

/**
 * 266.回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class CanPermutePalindrome {

    /**
     * 判断字符串是否可以通过重新排列成为回文串。
     *
     * @param s 输入字符串
     * @return 是否可以排列成回文串
     * 算法思路：
     * 回文串的特性是，最多只有一个字符出现奇数次，其他字符必须出现偶数次。
     * 使用哈希表统计每个字符的出现次数，并判断奇数次数的字符是否超过 1。
     */
    public static boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        // 统计每个字符的出现次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // 检查出现奇数次的字符数量
        int oddCount = 0;
        for (Integer cnt : charCountMap.values()) {
            if (cnt % 2 == 1) {
                oddCount++;
                // 如果超过一个字符出现奇数次，无法组成回文
                if (oddCount > 1) {
                    return false;
                }
            }
        }

        // 至多一个字符出现奇数次时，字符串可以排列成回文
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));// 输出: true
        System.out.println(canPermutePalindrome("code"));// 输出: false
        System.out.println(canPermutePalindrome("aab"));// 输出: true
        System.out.println(canPermutePalindrome("carerac"));// 输出: true
    }
}
