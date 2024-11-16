package org.example.string;

import java.util.Random;

/**
 * 实现水塘抽样算法以均匀选择目标字符索引
 * 给定一个字符串abcdabgh，给个字符a，随机返回a下标，比如这个是0 4。
 * 要求返回的概率必须一样，空间复杂度要求O1即不能开任何空间存储下标，并且只能遍历一次。
 * Created on 2024/11/16 13:11
 */
public class RandomIndex {

    /**
     * 水塘抽样：这种算法适用于从未知长度的数据流中选择随机样本，确保概率分布均匀。
     * 单次遍历：该解决方案一次遍历字符串，使用计数器跟踪目标字符出现的次数。
     * 概率性：每次遇到目标字符，算法根据 1/count 的概率决定是否更新选择的索引。这样可以确保每个目标字符的索引被选中的概率相同。
     */
    public static int getRandomIndex(String s, char target) {
        Random random = new Random();
        // 初始值表示尚未遇到目标字符
        int resultIndex = -1;
        // 目标字符出现的次数
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                count++;
                // 以 1/count 的概率更新 resultIndex 为当前索引
                if (random.nextInt(count) == 0) {
                    resultIndex = i;
                }
            }
        }
        // 遍历结束后返回选择的索引
        return resultIndex;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandomIndex("abcdabgh", 'a'));
        }
    }
}
