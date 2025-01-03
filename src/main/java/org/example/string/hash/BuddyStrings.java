package org.example.string.hash;

/**
 * 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * Created on 2025/1/3 16:29
 */
public class BuddyStrings {

    /**
     * 判断是否可以通过交换s和goal中的两个字符使其与goal相等
     *
     * @param s    原字符串
     * @param goal 目标字符串
     * @return 如果可以通过交换两个字符使得s和goal相等，则返回true，否则返回false
     */
    public static boolean buddyStrings(String s, String goal) {
        // 1、判断两个字符串的长度是否相同
        if (s.length() != goal.length()) {
            return false;
        }

        // 2、统计两个字符串的字符频率
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // 记录字符位置不同的数量
        int diffCount = 0;

        // 3、遍历字符串，统计字符频率并找出不同的位置
        for (int i = 0; i < s.length(); i++) {
            int index1 = s.charAt(i) - 'a';
            int index2 = goal.charAt(i) - 'a';
            count1[index1]++;
            count2[index2]++;

            if (index1 != index2) {
                diffCount++;
            }
        }

        // 4、如果两个字符串的字符频率不一致，返回false
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        // 5、如果两个字符串相同，检测是否有重复字符
        if (diffCount == 0) {
            for (int i = 0; i < 26; i++) {
                if (count1[i] > 1) {
                    return true;//有重复字符，交换相同字符后可以保持相等
                }
            }
            return false;//如果没有重复字符，不能通过交换保持相等
        }

        // 6、如果两个字符串不同，检查是否能通过交换两个字符使其相等
        return diffCount == 2;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba")); // true
        System.out.println(buddyStrings("ab", "ab")); // false
        System.out.println(buddyStrings("aa", "aa")); // true
    }
}
