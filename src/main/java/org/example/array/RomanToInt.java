package org.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * 示例 1:
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * Created on 2024/12/4 20:54
 */
public class RomanToInt {

    /**
     * 罗马数字转整数
     * 算法思路：
     * 1. 创建一个映射表，将罗马数字字符与其对应的整数值关联。
     * 2. 遍历罗马数字字符串，判断当前字符与下一个字符的大小关系：
     * - 如果当前字符的值小于下一个字符的值，则减去当前字符的值；
     * - 否则加上当前字符的值。
     * 3. 返回最终的结果。
     *
     * @param s 罗马数字字符串
     * @return 对应的整数
     */
    public static int romanToInt(String s) {
        // 使用 HashMap 存储罗马数字字符和对应的整数值
        Map<Character, Integer> romanToValueMap = new HashMap<>();
        romanToValueMap.put('I', 1);
        romanToValueMap.put('V', 5);
        romanToValueMap.put('X', 10);
        romanToValueMap.put('L', 50);
        romanToValueMap.put('C', 100);
        romanToValueMap.put('D', 500);
        romanToValueMap.put('M', 1000);

        // 结果变量
        int totalValue = 0;

        // 遍历罗马数字字符串
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanToValueMap.get(s.charAt(i));

            // 如果当前字符的值小于下一个字符的值，则做减法
            // 需要确保当前字符不是最后一个字符，避免越界
            if (i + 1 < s.length() && currentValue < romanToValueMap.get(s.charAt(i + 1))) {
                totalValue -= currentValue;// 执行减法
            } else {
                totalValue += currentValue;// 否则执行加法
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        System.out.println("III => " + romanToInt("III")); // 3
        System.out.println("IV => " + romanToInt("IV")); // 4
        System.out.println("IX => " + romanToInt("IX")); // 9
        System.out.println("LVIII => " + romanToInt("LVIII")); // 58
        System.out.println("MCMXCIV => " + romanToInt("MCMXCIV")); // 1994
    }
}
