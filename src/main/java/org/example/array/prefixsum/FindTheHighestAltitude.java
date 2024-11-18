package org.example.array.prefixsum;

/**
 * Created on 2024/11/18 11:48
 */
public class FindTheHighestAltitude {
    /**
     * 计算自行车手骑行过程中的最高海拔。
     * 核心思路：
     * 1. 从海拔为0的点开始，累加每个点的海拔高度差。
     * 2. 记录当前的海拔高度，并更新最高海拔。
     * 时间复杂度：O(n)，n 是数组 gain 的长度。
     * 空间复杂度：O(1)，只使用了常数空间。
     */
    public static int largestAltitude(int[] gain) {
        // 记录当前的最大海拔
        int max = 0;
        // 当前海拔
        int cur = 0;
        // 遍历 gain 数组，累加海拔变化
        for (int g : gain) {
            // 更新当前海拔
            cur += g;
            // 更新最大海拔
            max = Math.max(max, cur);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));  // 输出：1
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));  // 输出：0
    }
}
