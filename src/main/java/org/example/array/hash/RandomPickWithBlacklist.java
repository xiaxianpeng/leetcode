package org.example.array.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 710. 黑名单中的随机数
 * 给定一个整数 n 和一个 无重复 黑名单整数数组blacklist。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个未加入黑名单blacklist的整数。
 * 任何在上述范围内且不在黑名单blacklist中的整数都应该有 同等的可能性 被返回。
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * 实现Solution类:
 * Solution(int n, int[] blacklist)初始化整数 n 和被加入黑名单blacklist的整数
 * int pick()返回一个范围为 [0, n - 1] 且不在黑名单blacklist 中的随机整数
 * 示例 1：
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 * // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
 * 算法思路:
 * 本算法实现了一个数据结构，用于从给定范围 [0, n - 1] 内随机选取一个不在黑名单中的数字。
 * 它通过计算白名单的大小（n 减去黑名单长度），并构建一个从黑名单数字到白名单数字的映射来实现。
 * 对于在 [0, whitelistSize - 1] 范围内的黑名单数字，
 * 我们将它们映射到 [whitelistSize, n - 1] 范围内的某个非黑名单数字。
 * 这样，当我们从 [0, whitelistSize - 1] 范围内随机选取索引时，
 * 我们可以直接返回这个索引（如果它不是黑名单数字）或者返回它映射的数字（如果它是黑名单数字）。
 * 这确保了每次随机选取的结果都是等概率的，并且不会选取到黑名单中的数字。
 */
public class RandomPickWithBlacklist {

    /**
     * 白名单数字的数量，即除去黑名单之后的有效数字总数
     */
    int whitelistSize;
    /**
     * 黑名单数字和白名单数字之间的映射
     */
    Map<Integer, Integer> blacklistToWhitelistMapping;
    /**
     * 生成随机数的实例
     */
    Random random;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        // 计算白名单数字的数量
        whitelistSize = n - blacklist.length;
        // 初始化映射表
        blacklistToWhitelistMapping = new HashMap<>();
        // 初始化随机数生成器
        random = new Random();

        // 将黑名单数字加入映射表
        for (int b : blacklist) {
            blacklistToWhitelistMapping.put(b, -1);
        }

        // 最后一个可能被映射的白名单数字
        int last = n - 1;
        for (int b : blacklist) {
            // 如果黑名单数字已经在白名单范围之外，无需映射
            // 如果b已经存在区间[whitelistSize,n],可直接忽略,
            // 此黑名单的值b不需要映射一个白名单的值，因为它原本就在后面部分的区间，随机取值取不到这里
            if (b >= whitelistSize) {
                continue;
            }
            // 跳过所有黑名单的数字,找到一个不在黑名单中的数字作为映射目标
            while (blacklistToWhitelistMapping.containsKey(last)) {
                last--;
            }
            // 将黑名单数字映射到找到的白名单数字
            blacklistToWhitelistMapping.put(b, last);
            last--;
        }
    }

    int pick() {
        // 在白名单数字范围内随机选取一个索引
        int index = random.nextInt(whitelistSize);
        // 如果选取的索引对应的数字出现在黑名单中，返回映射的白名单数字
        // 否则，直接返回选取的索引对应的数字
        if (blacklistToWhitelistMapping.containsKey(index)) {
            return blacklistToWhitelistMapping.get(index);
        }
        //否则取的是白名单值，直接返回
        return index;
    }

    public static void main(String[] args) {
        RandomPickWithBlacklist randomPickWithBlacklist = new RandomPickWithBlacklist(7, new int[]{2, 3, 5});
        for (int i = 0; i < 7; i++) {
            System.out.println(randomPickWithBlacklist.pick());
        }
    }
}
