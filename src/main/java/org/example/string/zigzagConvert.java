package org.example.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * Created on 2024/12/5 09:35
 */
public class zigzagConvert {

    /**
     * 将字符串进行 Z 字形排列并返回结果字符串
     *
     * @param s       输入字符串
     * @param numRows 指定的行数
     * @return 经过 Z 字形变换后的字符串
     */
    public static String convert(String s, int numRows) {
        // 特殊情况处理，如果只有一行，直接返回字符串
        if (numRows == 1 || s.length() <= numRows) {
            System.out.println("无需处理，直接返回原字符串: " + s);
            return s;
        }

        // 创建一个 StringBuilder 数组，每个 StringBuilder 对应一行
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuffer());
        }

        // 当前行的索引
        int currentRow = 0;
        // 控制方向的变量，初始为 -1，因为第一步会向下移动
        int direction = -1;

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction = -direction;// 反转方向
                System.out.println("方向改变，当前方向: " + (direction > 0 ? "向下" : "向上"));
            }
            // 根据方向更新当前行索引
            currentRow += direction;
        }

        // 将所有行的字符拼接起来，形成最终结果
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            System.out.println("第 " + i + " 行内容: " + rows.get(i));
            result.append(rows.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("输入: " + s1 + ", numRows = " + numRows1);
        System.out.println("输出: " + convert(s1, numRows1)); // 输出 "PAHNAPLSIIGYIR"

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("输入: " + s2 + ", numRows = " + numRows2);
        System.out.println("输出: " + convert(s2, numRows2)); // 输出 "PINALSIGYAHRPI"

        String s3 = "A";
        int numRows3 = 1;
        System.out.println("输入: " + s3 + ", numRows = " + numRows3);
        System.out.println("输出: " + convert(s3, numRows3)); // 输出 "A"
    }
}
