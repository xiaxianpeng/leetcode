package org.example.string;

import java.util.ArrayList;

/**
 * @author xianpeng.xia
 * on 2022/4/5 10:35 AM
 * 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {

    private String[] letterMap = {
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
     * 字母组合
     */
    private ArrayList<String> combinations;

    /**
     * @param digits 2，3
     * @return 字母组合
     */
    public ArrayList<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if ("".equals(digits)) {
            return combinations;
        }
        findCombination(digits, 0, "");
        return combinations;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            combinations.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        String digist = "234";
        System.out.println(solution.letterCombinations(digist));
    }

}
