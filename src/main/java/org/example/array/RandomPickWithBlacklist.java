package org.example.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xianpeng.xia
 * on 2022/4/17 7:05 PM
 *
 *
 * 给定一个整数 n 和一个 无重复 黑名单整数数组blacklist。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个未加入黑名单blacklist的整数。
 * 任何在上述范围内且不在黑名单blacklist中的整数都应该有 同等的可能性 被返回。
 *
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 *
 * 实现Solution类:
 *
 * Solution(int n, int[] blacklist)初始化整数 n 和被加入黑名单blacklist的整数
 * int pick()返回一个范围为 [0, n - 1] 且不在黑名单blacklist 中的随机整数
 *
 * 示例 1：
 *
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 *
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomPickWithBlacklist {

    /**
     * 表示白名单的个数
     */
    int sz;
    /**
     * 将黑名单的数放进map中，value随便设，
     * 这里主要是为了判断黑名单的某个值是否在[N-lacklist.length, N)这个区间中，
     * 如果在，不需要建立映射了
     */
    Map<Integer, Integer> mapping = new HashMap<>();

    public RandomPickWithBlacklist(int N, int[] blacklist) {
        sz = N - blacklist.length;
        // 先将黑名单数字加入map；
        for (int b : blacklist) {
            mapping.put(b, Integer.MIN_VALUE);
        }
        //
        int last = N - 1;
        for (int b : blacklist) {
            // 如果b已经存在区间[sz,N],可直接忽略,
            // 此黑名单的值b不需要映射一个白名单的值，因为它原本就在后面部分的区间，随机取值取不到这里
            if (b >= sz) {
                continue;
            }
            // 跳过所有黑名单的数字
            while (mapping.containsKey(last)) {
                last--;
            }
            // 将黑名单中的索引映射到合法数字
            mapping.put(b, last);
            last--;
        }
    }

    int pick() {
        // 随机选择一个索引
        int index = new Random().nextInt(sz);
        //如果随机取到的这个值是黑名单的值（这个黑名单中的值在前面部分区间内，所以能取到），则直接取这个黑名单映射的位于后面部分区间的白名单值
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        //否则取的是白名单值，直接返回
        return index;
    }

    public static void main(String[] args) {
        int N = 7;
        int[] blacklist = new int[]{2, 3, 5};
        RandomPickWithBlacklist randomPickWithBlacklist = new RandomPickWithBlacklist(N, blacklist);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomPickWithBlacklist.pick());
        }
    }
}
