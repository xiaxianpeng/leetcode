package org.example.twopointers.string;

/**
 * 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
public class ReverseWords {

    /**
     * 反转字符串中的单词
     * 算法思路：
     * 1. 使用 trim() 方法去除字符串的前导和尾随空格。
     * 2. 使用双指针（i 和 j）从字符串的末尾开始遍历，逐个提取单词。
     * 3. 每次找到一个单词后，加入结果字符串，并跳过单词之间的空格。
     * 4. 拼接完成后，返回最终结果时去除多余的空格。
     *
     * @param s 输入的字符串
     * @return 反转后的字符串，单词之间用单个空格分隔
     */
    public static String reverseWords(String s) {
        // 去除前导和尾随空格
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuffer result = new StringBuffer();

        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // 将单词拼接到结果中
            result.append(s.substring(i + 1, j + 1) + " ");

            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // 更新 j 为当前单词的结束位置
            j = i;
        }

        // 返回结果
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        String s1 = "  hello world  ";
        System.out.println(reverseWords(s1));
        String s2 = "a good   example";
        System.out.println(reverseWords(s2));
    }
}
