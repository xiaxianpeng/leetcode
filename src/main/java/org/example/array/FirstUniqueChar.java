package org.example.array;

/**
 * @author xianpeng.xia
 * on 2021/2/28 9:14 下午
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {

    public static int solution(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(solution(s));
    }
}
