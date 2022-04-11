package org.example.string;

/**
 * @author xianpeng.xia
 * on 2022/4/11 12:07 PM
 *
 * 171. Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 */
public class TitleToNumber {

    /**
     * @param title title
     * @return number
     *
     * 1，计算其代表的数值 num = 字母 - ‘A’ + 1
     * 2、每遍历一位则ans = ans * 26 + num
     */
    public static int titleToNumber(String title) {
        int ans = 0;
        int length = title.length();
        for (int i = 0; i < length; i++) {
            int num = title.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        String title = "AB";
        int number = titleToNumber(title);
        System.out.println(number);
    }
}
