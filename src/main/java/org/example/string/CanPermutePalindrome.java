package org.example.string;

import java.util.HashMap;

/**
 * @author xianpeng.xia
 * on 2022/4/5 2:12 PM
 * 判断字符串是否能组成回文
 *
 *
 * 1、所有不同字符都出现偶数次
 * 2、只有一个字符出现基数次，其他字符出现偶数次
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPermutePalindrome {

    public static boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dic.put(c, dic.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (Integer cnt : dic.values()) {
            if (cnt % 2 == 1) {
                if (++odd > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println(canPermutePalindrome(s));
    }
}
