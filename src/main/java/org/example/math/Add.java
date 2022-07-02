package org.example.math;

/**
 * @author xianpeng.xia
 * on 2022/7/2 23:40
 *
 * 大数加法
 */
public class Add {

    public String add(String num1, String num2) {

        StringBuffer ans = new StringBuffer();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            ans.append(sum);
            carry = (x + y + carry) / 10;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String sum = new Add().add(num1, num2);
        System.out.println(sum);
    }
}
