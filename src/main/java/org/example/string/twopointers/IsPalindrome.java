package org.example.string.twopointers;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class IsPalindrome {

    /**
     * 判断给定字符串是否为回文串
     * 算法思路：
     * 1. 使用双指针，从字符串的两端开始。
     * 2. 忽略非字母和非数字字符。
     * 3. 忽略大小写，确保字符比较时不受大小写影响。
     * 4. 当两个指针相遇时，字符串为回文串，否则不是。
     *
     * @param s 输入字符串
     * @return 如果字符串是回文串，则返回 true，否则返回 false
     */
    public static boolean isPalindrome(String s) {
        // 保存字母和数字的字符
        StringBuffer sb = new StringBuffer();

        // 遍历原字符串，将符合条件的字符加入 sb 中
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));// 转为小写，统一处理
            }
        }


        //双指针
        int left = 0;
        int right = sb.length() - 1;
        // 使用双指针法进行回文检查
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;// 如果有不匹配的字符，返回 false
            }
            left++; // 左指针右移
            right--;// 右指针左移
        }

        return true;// 如果没有发现不匹配的字符，返回 true
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
