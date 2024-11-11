package org.example.array.diff;

/**
 * 1094. 拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengers.i, from.i, to.i] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * 示例 1：
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 链接：https://leetcode.cn/problems/car-pooling/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/11 21:10
 */
public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        // 根据题目给定的 trips，确定差分数组的长度
        int toMax = 0;
        for (int[] trip : trips) {
            // trip[2] 表示下车位置，需要遍历到最远的下车点
            toMax = Math.max(toMax, trip[2]);
        }
        // 创建差分数组
        int[] diff = new int[toMax + 1];
        // 构建差分数组
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            // 乘客在 from 点上车
            diff[from] += numPassengers;
            // 乘客在 to 点下车
            diff[to] -= numPassengers;
        }
        // 使用差分数组的前缀和来判断在任一点是否超载
        int currentPassengers = 0;
        for (int i = 0; i < diff.length; i++) {
            currentPassengers += diff[i];
            // 如果超过车的容量，返回 false
            if(currentPassengers>capacity){
                return false;
            }
        }
        // 所有行程结束后没有超载，返回 true
        return true;
    }


    public static void main(String[] args) {
        // 测试用例1，预期输出：false
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        System.out.println("Test case 1: " + carPooling(trips1, capacity1)); // 应该输出 false

        // 测试用例2，预期输出：true
        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        int capacity2 = 5;
        System.out.println("Test case 2: " + carPooling(trips2, capacity2)); // 应该输出 true
    }
}
