package org.example.backtrack.array;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class FindTargetSumWays {

    int count = 0;

    /**
     * 调用回溯方法，从0索引开始为每个元素选择+或者-，统计满足target的方案数
     *
     * @param nums   整数数组
     * @param target 目标和
     * @return 符合条件的表达式数量
     */
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    /**
     * 回溯函数
     *
     * @param nums       整数数组
     * @param target     目标和
     * @param index      当前处理到nuns的第index个元素
     * @param currentSum 当前表达式已计算出的和
     */
    private void backtrack(int[] nums, int target, int index, int currentSum) {
        // 当处理到数组末尾时，检查是否与target匹配
        if (index == nums.length) {
            System.out.println("到达数组末尾，当前计算和为: " + currentSum + (currentSum == target ? "，符合目标！" : "，不符合目标。"));
            if (currentSum == target) {
                count++;
            }
            return;
        }
        // 为当前元素选择+号
        System.out.println("索引 " + index + "，元素值 " + nums[index] + "，选择 '+'，新和为：" + (currentSum + nums[index]));
        backtrack(nums, target, index + 1, currentSum + nums[index]);
        // 为当前元素选择-号
        System.out.println("索引 " + index + "，元素值 " + nums[index] + "，选择 '-'，新和为：" + (currentSum - nums[index]));
        backtrack(nums, target, index + 1, currentSum - nums[index]);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println("nums=[1,1,1,1,1], target=3");
        int result1 = new FindTargetSumWays().findTargetSumWays(nums1, target1);
        System.out.println("结果：" + result1);

        System.out.println();

        int[] nums2 = {1};
        int target2 = 1;
        System.out.println("nums=[1], target=1");
        int result2 = new FindTargetSumWays().findTargetSumWays(nums2, target2);
        System.out.println("结果：" + result2);
    }

}
