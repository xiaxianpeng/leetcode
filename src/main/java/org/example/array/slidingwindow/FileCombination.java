package org.example.array.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 180. 文件组合
 * 待传输文件被切分成多个部分，
 * 按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。
 * 传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。
 * 请返回所有符合该要求的文件传输组合列表。
 * 注意，返回时需遵循以下规则：
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 * 示例 1：
 * 输入：target = 12
 * 输出：[[3, 4, 5]]
 * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
 * 示例 2：
 * 输入：target = 18
 * 输出：[[3,4,5,6],[5,6,7]]
 * 解释：在上述示例中，存在两个连续正整数序列的和分别为 18，分别为 [3, 4, 5, 6] 和 [5, 6, 7]。
 * Created on 2024/12/22 14:43
 */
public class FileCombination {

    /**
     * 寻找所有连续正整数序列，其和等于目标值target
     *
     * @param target 目标和
     * @return 所有符合条件的连续整数序列
     * 算法思路：
     * 使用双指针方法(滑动窗口)从1开始遍历，逐步增加窗口大小或移动起点
     * 以找到所有满足连续整数和为target的序列
     */
    public static List<List<Integer>> fileCombinations(int target) {

        List<List<Integer>> results = new ArrayList<>();

        int start = 1;//窗口的起始点
        int end = 2;//窗口的结束点

        int currentSum = start + end;//当前窗口的和

        while (start < end && start <= target / 2) {
            if (currentSum == target) {
                // 找到一个符合条件的序列
                List<Integer> result = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
                results.add(result);

                //移动起始指针，准备寻找下一个序列
                currentSum -= start;
                start++;
            } else if (currentSum < target) {
                // 当前和小于目标，扩大窗口
                end++;
                currentSum += end;
            } else {
                // 当前和小于目标，缩小窗口
                currentSum -= start;
                start++;
            }
        }

        return results;
    }

    public static void main(String[] args) {

        List<List<Integer>> result1 = fileCombinations(12);
        System.out.println("Combinations: " + result1);

        System.out.println();

        List<List<Integer>> result2 = fileCombinations(18);
        System.out.println("Combinations: " + result2);
    }
}
