package org.example.string;

/**
 * @author xianpeng.xia
 * on 2022/3/27 11:57 AM
 * 通过空格分割的字符串，求最长子字符串长度，尽可能优化。例如,输入："ab ab abcd bbb"，输出4。
 */
public class MaxSubStringLength {

    public static int simpleSolution(String s) {
        int max = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                temp = 0;
            } else {
                temp++;
            }
            max = max > temp ? max : temp;
        }
        return max;
    }

    public static int solution(String s) {
        int max = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        String[] stringArray = s.split(" ");

        for (String s1 : stringArray) {
            max = max > s1.length() ? max : s1.length();
        }
        return max;
    }

    public static void main(String[] args) {
        int maxSubStringLength = solution("ab ab abcd bbb");
        System.out.println(maxSubStringLength);
    }
}
