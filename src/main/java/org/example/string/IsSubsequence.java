package org.example.string;

/**
 * @author xianpeng.xia
 * on 2022/3/28 1:48 PM
 * 给定字符串s和t，判断s是否为t的⼦序列。
 * 进阶：如果有⼤量输⼊的 S，称作 S1, S2, ... , Sk 其中 k > 10 亿，
 * 你需要依次检查它们是否为 T 的⼦ 序列。在这种情况下，你会怎样改变代码？
 * 示例 1：输⼊：s = "abc", t = "ahbgdc"
 * 输出：true
 * 基本思路 ⼒扣上的这道题很简单，利⽤双指针 i, j 分别指向 s, t，⼀边前进⼀边匹配⼦序列。
 */
public class IsSubsequence {

    public boolean solution(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.solution(s, t));
    }
}
