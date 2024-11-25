package org.example.array.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinations {

    // 数字到字母的映射
    private static final String[] KEYPAD = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };


    /**
     * 生成并返回给定数字字符串的所有可能的字母组合。
     *
     * @param digits 输入的数字字符串（仅包含2-9）。
     * @return 字母组合的列表。
     */
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        // 如果输入为空，返回空列表
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        // 开始回溯
        backtrack(digits, 0, new StringBuffer(), combinations);
        return combinations;
    }

    /**
     * 辅助函数，使用回溯生成字母组合。
     *
     * @param digits       输入的数字字符串。
     * @param index        当前处理的字符串索引。
     * @param current      当前的组合。
     * @param combinations 存储结果的列表。
     */
    private static void backtrack(String digits, int index, StringBuffer current, List<String> combinations) {
        // 如果当前组合完成，加入到结果列表中
        if (index == digits.length()) {
            combinations.add(current.toString());
            System.out.println("Complete combination: " + current.toString());
            return;
        }

        // 获取当前数字对应的字母
        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];
        // 显示当前的数字和可能的字母
        System.out.printf("Digit: %d, Letters: %s\n", digit, letters);

        for (char letter : letters.toCharArray()) {
            current.append(letter);// 将字母加入当前组合
            System.out.printf("Adding letter '%c' to current: %s\n", letter, current.toString());

            backtrack(digits, index + 1, current, combinations);// 递归处理下一个数字

            current.deleteCharAt(current.length() - 1);// 撤销选择
            System.out.printf("Backtracking, removing letter '%c', current: %s\n", letter, current.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // 输出: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("")); // 输出: []
        System.out.println(letterCombinations("2")); // 输出: ["a","b","c"]
    }

}
