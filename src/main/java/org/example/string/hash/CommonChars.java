package org.example.string.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. 查找共用字符
 * 给你一个字符串数组 words ，
 * 请你找出所有在 words 的每个字符串中都出现的共用字符（包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 * 示例 1：
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 * Created on 2025/1/2 09:17
 */
public class CommonChars {

    /**
     * 查找共用字符
     *
     * @param words 字符串数组
     * @return 公用字符数组
     * 算法思路：
     * 利用字符频次统计，
     * 先记录第一个单词中每个字符出现的次数，
     * 然后依次与后续单词进行最小频次更新
     */
    public static List<String> commonChars(String[] words) {
        // 记录所有字母的全局最小频次，a~z
        int[] minFreq = new int[26];

        // 1、初始化，统计第一个单词中每个字母的出现频次
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // 2、从第二个单词开始，与minFreq进行比较更新
        for (int i = 1; i < words.length; i++) {

            // currentFreq统计当前单词中每个字母出现的频次
            int[] currentFreq = new int[26];
            for (char c : words[i].toCharArray()) {
                currentFreq[c - 'a']++;
            }

            // 用最小值更新minFreq
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], currentFreq[j]);
            }
        }

        // 3、将每个字符按照minFreq填充到结果列表
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char commonChar = (char) (i + 'a');
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf(commonChar));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String[] words1 = {"bella", "label", "roller"};
        System.out.println(Arrays.toString(words1));
        System.out.println("CommonChars" + commonChars(words1));

        String[] words2 = {"cool", "lock", "cook"};
        System.out.println(Arrays.toString(words2));
        System.out.println("CommonChars" + commonChars(words2));
    }
}
