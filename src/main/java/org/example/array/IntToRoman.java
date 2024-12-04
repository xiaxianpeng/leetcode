package org.example.array;

/**
 * 12. 整数转罗马数字
 * 七个不同的符号代表罗马数字，其值如下：
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，
 * 例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。
 * 仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 * 示例 1：
 * 输入：num = 3749
 * 输出： "MMMDCCXLIX"
 * 解释：
 * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 * 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 * 40 = XL 由于 50 (L) 减 10 (X)
 * 9 = IX 由于 10 (X) 减 1 (I)
 * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 * 示例 2：
 * 输入：num = 58
 * 输出："LVIII"
 * 解释：
 * 50 = L
 * 8 = VIII
 * 示例 3：
 * 输入：num = 1994
 * 输出："MCMXCIV"
 * 解释：
 * 1000 = M
 * 900 = CM
 * 90 = XC
 * 4 = IV
 * Created on 2024/12/4 21:10
 */
public class IntToRoman {

    /**
     * 将整数转换为罗马数字
     * 算法思路：
     * 1. 使用两个数组：一个存储罗马符号，一个存储对应的整数值。
     * 2. 从大到小遍历这些符号，根据当前整数值逐步减去并附加相应符号。
     * 3. 直到整数变为零，返回结果字符串。
     *
     * @param num 要转换的整数
     * @return 转换后的罗马数字
     */
    public static String intToRoman(int num) {
        // 罗马数字符号和对应的整数值
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < romanSymbols.length; i++) {
            int value = romanValues[i];

            while (num >= value) {
                roman.append(romanSymbols[i]);
                num -= value;
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println("3749 => " + intToRoman(3749)); // MMMDCCXLIX
        System.out.println("58 => " + intToRoman(58));     // LVIII
        System.out.println("1994 => " + intToRoman(1994)); // MCMXCIV
        System.out.println("9 => " + intToRoman(9));       // IX
        System.out.println("4 => " + intToRoman(4));       // IV
    }

}
