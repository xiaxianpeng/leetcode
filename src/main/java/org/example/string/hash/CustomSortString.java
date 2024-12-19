package org.example.string.hash;

/**
 * 791. 自定义字符串排序
 * 给定两个字符串 order 和 s 。order 的所有字母都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。
 * 更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * 返回 满足这个性质的 s 的任意一种排列 。
 * 示例 1:
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * "a"、"b"、"c"是按顺序出现的，所以"a"、"b"、"c"的顺序应该是"c"、"b"、"a"。
 * 因为"d"不是按顺序出现的，所以它可以在返回的字符串中的任何位置。"dcba"、"cdba"、"cbda"也是有效的输出。
 * 示例 2:
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 * 解释：字符 "b"、"c" 和 "a" 规定了 s 中字符的顺序。s 中的字符 "d" 没有在 order 中出现，所以它的位置是弹性的。
 * 按照出现的顺序，s 中的 "b"、"c"、"a" 应排列为"b"、"c"、"a"。"d" 可以放在任何位置，因为它没有按顺序排列。
 * 输出 "bcad" 遵循这一规则。其他排序如 "dbca" 或 "bcda" 也是有效的，只要维持 "b"、"c"、"a" 的顺序。
 * Created on 2024/12/19 10:37
 */
public class CustomSortString {
    /**
     * 根据给定的order对字符串s进行自定义排序
     *
     * @param order 排序的规则字符串，包含所有唯一的字母
     * @param s     要进行排序的字符串
     * @return 排序后的字符串
     * 算法思路：
     * 1、统计s中每个字符的出现次数，并存入一个频率数组中
     * 2、遍历order中的字符，按照order的顺序将s中对应的字符的出现次数添加到结果中
     * 3、最后，添加s中剩余的字符(即不在order中的字符)，按字母升序添加
     */
    public static String customSortString(String order, String s) {
        // 1、统计s中每个字符出现的次数
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;//根据字符的ASCII值减去'a'来定位字符
        }

        StringBuffer result = new StringBuffer();
        // 2、遍历order中的字符，按order的顺序添加字符
        for (char c : order.toCharArray()) {
            // 添加order中字符的所有出现次数
            while (counts[c - 'a']-- > 0) {
                result.append(c);
                System.out.println("当前字符：" + c + ", 剩余次数：" + counts[c - 'a']);
            }
        }

        // 3、添加s中剩余的字符，按字母升序排列
        for (int i = 0; i < 26; i++) {
            while (counts[i]-- > 0) {
                result.append((char) (i + 'a'));
                System.out.println("当前字符：" + (char) (i + 'a') + ", 剩余次数：" + counts[i]);
            }
        }

        // 返回排列的字符串
        return result.toString();
    }

    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println("排序后的字符串：" + customSortString(order, s));
    }
}
