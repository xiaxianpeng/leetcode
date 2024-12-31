package org.example.hash.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。
 * 一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * 示例 1:
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * Created on 2025/1/1 00:09
 */
public class FrequencySort {

    /**
     * 根据字符出现频率对字符串进行降序排序
     *
     * @param s 输入字符串
     * @return 按照字符频率排序后的字符串
     * 算法思路：
     * 1、统计每个字符的出现频率
     * 2、使用最大堆按照频率降序排列字符
     * 3、依次取出频率最高的字符，构建最终的排序字符串
     */
    public static String frequencySort(String s) {
        // 创建一个哈希映射，用来存储每个字符的频率
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // 创建一个最大堆，根据字符的频率进行排序
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        // 使用StringBuffer构建结果字符串
        StringBuffer result = new StringBuffer();
        while (!maxHeap.isEmpty()) {
            // 取出频率最高的字符
            char currentChar = maxHeap.poll();
            int count = freqMap.get(currentChar);

            // 将字符按照其频率添加到结果字符串中
            for (int i = 0; i < count; i++) {
                result.append(currentChar);
            }
        }

        // 返回最终排序的字符串
        return result.toString();
    }

    public static void main(String[] args) {

        String test1 = "tree";
        String result1 = frequencySort(test1);
        System.out.println(test1 + "\n" + result1);

        String test2 = "cccaaa";
        String result2 = frequencySort(test2);
        System.out.println(test2 + "\n" + result2);

        String test3 = "Aabb";
        String result3 = frequencySort(test3);
        System.out.println(test3 + "\n" + result3);
    }
}
