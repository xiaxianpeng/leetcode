package org.example.array.greedy;

/**
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 * 示例 1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class GasStation {

    /**
     * 利用贪心算法，遍历每个加油站作为起点，尝试从该加油站出发，计算能否完成一圈。
     * 如果在某次尝试中发现油量不足以到达下一个加油站，则从失败点之后的加油站重新尝试。
     * 因为如果从某个起点出发无法到达某个加油站，那么任何位于这两个加油站之间的站点作为起点也无法到达目标加油站。
     *
     * @param gas  每个加油站的汽油量
     * @param cost 从一个加油站到下一个加油站所需的油量
     * @return 能够完成一圈的起点加油站的索引，若不存在则返回 -1
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // 遍历每一个加油站作为起点
        for (int startStation = 0; startStation < n; startStation++) {
            int totalGas = 0;   // 累积油量
            int totalCost = 0;  // 累积消耗油量

            // 从 startStation 出发，尝试行驶一圈
            for (int steps = 0; steps < n; steps++) {
                // 当前加油站的位置，循环环绕
                int currentStation = (startStation + steps) % n;

                // 累加油量和消耗油量
                totalGas += gas[currentStation];
                totalCost += cost[currentStation];

                // 如果油量不足以到达下一个加油站，则无法完成一圈
                if (totalCost > totalGas) {
                    break;
                }
            }

            // 如果成功绕一圈，返回当前起始加油站的索引
            if (totalGas >= totalCost) {
                return startStation;
            }
        }

        // 如果无法从任何一个加油站出发完成一圈，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));  // 输出: 3

        int[] gas2 = new int[]{2, 3, 4};
        int[] cost2 = new int[]{3, 4, 3};
        System.out.println(canCompleteCircuit(gas2, cost2));  // 输出: -1
    }
}
