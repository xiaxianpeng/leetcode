package org.example.string.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 792. 匹配子序列的单词数
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 例如， “ace” 是 “abcde” 的子序列。
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出:
 * Created on 2024/12/18 18:05
 */
public class NumMatchingSubseq {

    /**
     * 计算words中有多少个单词是s的子序列
     *
     * @param s     字符串s
     * @param words 单词
     * @return 子序列的单词个数
     */
    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> charIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charIndexes.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int count = 0;
        for (String word : words) {
            if (matchingSubseq(word, charIndexes)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 判断word是否是s的子序列
     *
     * @param word        要检查的单词
     * @param charIndexes 字符在s中出现的位置
     * @return 是否是s的子序列
     */
    private static boolean matchingSubseq(String word, Map<Character, List<Integer>> charIndexes) {
        int lastIndex = -1;
        System.out.println("检查 word: " + word);
        for (char c : word.toCharArray()) {
            // 如果字符在s中没有出现过，返回false
            if (!charIndexes.containsKey(c)) {
                System.out.println("字符 " + c + " 不在 s 中出现，返回 false");
                return false;
            }
            // 获取字符c在s中所有出现位置
            List<Integer> indexes = charIndexes.get(c);
            System.out.println("字符 " + c + " 的出现位置：" + indexes);
            // 在这些位置中，找到第一个大于lastIndex的位置
            int index = binarySearch(indexes, lastIndex);
            // 如果没有找到合适的位置，返回false
            if (index == indexes.size()) {
                System.out.println("没有找到合适的位置，返回 false");
                return false;
            }
            // 更新lastIndex为找到的位置
            lastIndex = indexes.get(index);
            System.out.println("更新 lastIndex: " + lastIndex);
        }
        System.out.println("成功匹配 word: " + word);
        return true;
    }

    /**
     * 二分查找，找到第一个大于lastIndex的位置
     *
     * @param indexes   字符位置列表
     * @param lastIndex 上一个匹配的位置
     * @return 第一个大于lastIndex的位置
     */
    private static int binarySearch(List<Integer> indexes, int lastIndex) {
        int left = 0;
        int right = indexes.size();

        // 使用二分查找
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (indexes.get(mid) > lastIndex) {
                right = mid;// 如果mid对应的位置大于lastIndex，就收缩有边界
            } else {
                left = mid + 1;//否则，收缩左边界
            }
        }
        // 返回第一个大于lastIndex的位置
        return left;
    }


    public static void main(String[] args) {
        String s = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }
}
