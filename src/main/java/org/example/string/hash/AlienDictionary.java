package org.example.string.hash;

/**
 * 953. 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。
 * 字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，
 * 以及其字母表的顺序 order，
 * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；
 * 否则，返回 false。
 * 示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，
 * 第二个字符串相对短一些，
 * 然后根据词典编纂规则 "apple" > "app"，
 * 因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * Created on 2024/12/19 20:34
 */
public class AlienDictionary {

    /**
     * 验证外星语词典的单词顺序是否正确
     *
     * @param words 外星语单词列表
     * @param order 外星语字母顺序
     * @return 是否按顺序排列
     * 算法思路：
     * 1、构建一个外星语字符顺序的映射表，记录每个字符的优先级
     * 2、比较相邻的两个单词，逐字符比较：
     * - 如果发现字符不同，根据order映射判断大小关系
     * - 如果所有字符相同但前一个单词长度大于后一个单词长度，返回false
     * 3、如果所有单词都符合顺序，返回true
     */
    public static boolean isAlienSorted(String[] words, String order) {
        // 1、构建字符顺序映射表
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        // 2、遍历单词数组，比较相邻的单词
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrdered(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较两个单词是否符合外星语的顺序
     *
     * @param word1    第一个单词
     * @param word2    第二个单词
     * @param orderMap 外星语字母顺序映射表
     * @return 是否按顺序排列
     */
    private static boolean isOrdered(String word1, String word2, int[] orderMap) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        int minLength = Math.min(word1Length, word2Length);

        for (int i = 0; i < minLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            // 如果字符不同，根据映射判断大小
            if (c1 != c2) {
                return orderMap[c1 - 'a'] < orderMap[c2 - 'a'];
            }

        }
        // 如果所有字符都相同，比较长度
        return word1Length < word2Length;

    }

    public static void main(String[] args) {
        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words1, order1)); // 输出: true

        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words2, order2)); // 输出: false

        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words3, order3)); // 输出: false
    }

}
