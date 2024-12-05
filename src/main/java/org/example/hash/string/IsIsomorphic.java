package org.example.hash.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * Created on 2024/12/5 16:29
 */
public class IsIsomorphic {

    /**
     * 判断两个字符串是否同构
     * 核心思路：
     * - 使用两个哈希映射，分别映射 s -> t 和 t -> s。
     * - 遍历字符串的每一对字符，确保映射关系是双向的且一致的。
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 如果两个字符串是同构的，返回 true；否则返回 false。
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false; // 长度不同直接返回 false
        }

        // 两个哈希映射，分别记录 s -> t 和 t -> s 的映射关系
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        // 遍历两个字符串
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // 检查 s -> t 的映射是否一致
            if (s2t.containsKey(charS)) {
                if (s2t.get(charS) != charT) {
                    System.out.println("Mismatch in s -> t mapping for " + charS + ": expected " + s2t.get(charS) + ", got " + charT);
                    return false;
                }
            } else {
                s2t.put(charS, charT);
            }

            // 检查 t -> s 的映射是否一致
            if (t2s.containsKey(charT)) {
                if (t2s.get(charT) != charS) {
                    System.out.println("Mismatch in t -> s mapping for " + charT + ": expected " + t2s.get(charT) + ", got " + charS);
                    return false;
                }
            } else {
                t2s.put(charT, charS);
            }
        }

        // 如果所有映射都一致，则返回 true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
    }
}
