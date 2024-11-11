package org.example.array.diff;

import org.example.util.ArrayUtil;

/**
 * 370. 区间加法 🔒
 * 题目描述
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
 * 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * 请你返回 k 次操作后的数组。
 * 示例:
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 * 初始状态:
 * [0,0,0,0,0]
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 * Created on 2024/11/11 23:01
 */
public class RangeAddition {

    /**
     * 差分数组 diff 保留了原数组 result 相邻元素的差值。
     * 如果我们想将 result 的一个子区间 [startIndex, endIndex] 内的所有元素增加 inc，
     * 我们只需要让 diff[startIndex] 增加 inc，diff[endIndex+1] 减去 inc，
     * 这样操作后 diff 数组在 [startIndex, endIndex] 区间内的前缀和都会增加 inc。
     * 这是因为 diff 数组与原数组 result 之间的关系是这样的：
     * result[0] = diff[0]
     * result[1] = diff[0] + diff[1]
     * result[2] = diff[0] + diff[1] + diff[2]
     * ...
     * result[i] = diff[0] + diff[1] + ... + diff[i]
     * 所以，如果我们在 diff 数组的 startIndex 增加 inc，
     * 那么根据上面的关系，从 result[startIndex] 到 result[n-1] 的所有元素都会增加 inc。
     * 为了抵消 endIndex 之后的增加，我们在 diff[endIndex+1] 减去 inc。
     * 这样，从 result[endIndex+1] 到 result[n-1] 的元素就不会受到影响。
     * 最后，通过对 diff 数组计算前缀和，我们可以得到调整后的 result 数组。
     * 这个差分数组技巧的优点在于更新操作的效率非常高，无论区间多大，更新操作的复杂度始终是 O(1)。
     * 而最终计算前缀和的操作复杂度是 O(n)，因此总的复杂度是 O(n + k)，这在有大量更新操作时是非常高效的。
     */
    public static int[] getModifiedArray(int length, int[][] updates) {
        // 初始化差分数组，初始值为 0
        int[] diff = new int[length];
        // 应用所有更新操作
        for (int[] update : updates) {
            // 更新操作的起始索引
            int startIndex = update[0];
            // 更新操作的结束索引
            int endIndex = update[1];
            // 更新操作的增量值
            int inc = update[2];
            // 将增量应用到差分数组的起始位置
            diff[startIndex] += inc;
            // 如果结束索引的下一个位置在数组范围内，将其减去增量
            if (endIndex + 1 < length) {
                diff[endIndex + 1] -= inc;
            }
        }
        // 根据差分数组计算结果数组
        int[] result = new int[length];
        // 第一个元素的值由差分数组的第一个值决定
        result[0] = diff[0];
        for (int i = 1; i < length; i++) {
            // 计算每个位置的值作为前一个位置的值加上差分数组对应位置的值
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] modifiedArray = getModifiedArray(length, updates);
        // 输出应为: -2 0 3 5 3
        ArrayUtil.print(modifiedArray);
    }
}
