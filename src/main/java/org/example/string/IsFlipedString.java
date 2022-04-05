package org.example.string;

/**
 * @author xianpeng.xia
 * on 2022/4/5 6:27 PM
 *
 * 字符串轮转
 *
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 */
public class IsFlipedString {

    /**
     * 1、选择任意位置，将字符串切分为两个子字符串 s1 = LR
     * 2、将R移动至L前面得到 s2 = RL
     *
     * 则s2+s2=RLRL,看是否包含s1
     */
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s2);
    }
}
