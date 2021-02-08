package org.example.set;

import java.util.TreeSet;

/**
 * @author xianpeng.xia
 * on 2021/2/8 2:31 下午
 *
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
public class UniqueMorseRepresentations {

    public static int count(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();

        for (String word : words) {
            StringBuffer res = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            System.out.println("word: " + word + " -> " + res.toString());
            set.add(res.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"ab", "ac"};
        System.out.println(count(words));
    }
}
