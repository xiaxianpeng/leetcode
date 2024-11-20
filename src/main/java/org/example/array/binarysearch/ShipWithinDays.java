package org.example.array.binarysearch;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。
 * 每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成
 * (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * Created on 2024/11/12 19:17
 */
public class ShipWithinDays {

    /**
     * 计算在指定天数内送达所有包裹的最小运载能力。
     *
     * @param weights 包裹重量数组
     * @param days    必须在天数
     * @return 最小运载能力
     */
    public static int shipWithinDays(int[] weights, int days) {
        // 初始化二分查找的左右边界
        int left = 0; // 最小运载能力为最大包裹重量
        int right = 0;// 最大运载能力为所有包裹重量之和
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // 二分查找
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果以 mid 作为运载能力是否可以在指定天数内运输运输完所有包裹
            if (canShip(weights, days, mid)) {
                // 如果可以，则尝试更小的运载能力
                right = mid;
            } else {
                // 如果不可以，则需要更大的运载能力
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canShip(int[] weights, int days, int capacity) {
        // 需要的天数
        int daysNeeded = 1;
        // 当前船的载重
        int currentCapacity = 0;
        for (int weight : weights) {
            // 如果当前包裹重量加上后超出运载能力，则需要增加一天
            if (currentCapacity + weight > capacity) {
                daysNeeded++;
                currentCapacity = 0;
            }
            // 装载当前包裹
            currentCapacity += weight;
        }
        // 返回是否在给定天数内完成运输
        return daysNeeded <= days;
    }


    public static void main(String[] args) {
        // 测试案例 1
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5;
        System.out.println("最小运载能力（案例 1）: " + shipWithinDays(weights1, days1)); // 输出应该是 15

        // 测试案例 2
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;
        System.out.println("最小运载能力（案例 2）: " + shipWithinDays(weights2, days2)); // 输出应该是 6

        // 测试案例 3
        int[] weights3 = {1, 2, 3, 1, 1};
        int days3 = 4;
        System.out.println("最小运载能力（案例 3）: " + shipWithinDays(weights3, days3)); // 输出应该是 3
    }
}
