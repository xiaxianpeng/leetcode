package org.example.array;

import java.util.Arrays;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber {

    /**
     * 算法思路：
     * 1. 将整数数组转换为字符串数组，以便进行字符串比较。
     * 2. 自定义排序规则：对于两个字符串 a 和 b，比较 a + b 与 b + a 的字典序。
     * 如果 a + b 比 b + a 大，则 a 应该排在 b 的前面，反之亦然。
     * 3. 对字符串数组进行排序。
     * 4. 如果排序后的第一个字符串是 "0"，则所有数字都是 0，直接返回 "0"。
     * 5. 否则，连接排序后的字符串数组，形成最终的最大数。
     *
     * @param nums 给定的非负整数数组
     * @return 重新排列后组成的最大的整数的字符串表示
     */
    public static String largestNumber(int[] nums) {
        // 将整数数组转换成字符串数组
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = nums[i] + "";
        }

        // 自定义排序规则,比较ab与ba,降序
        Arrays.sort(numStrs, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        System.out.println("排序后的字符串数组: " + Arrays.toString(numStrs));
        // 如果排序第一个数字是0，则所有数字都是0
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // 连接排序后的字符串数组，组成最大数
        StringBuffer largestNumberStr = new StringBuffer();
        for (String numStr : numStrs) {
            largestNumberStr.append(numStr);
        }
        return largestNumberStr.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 2};
        System.out.println("nums = " + Arrays.toString(nums1));
        String result1 = largestNumber(nums1);
        System.out.println("结果: \"" + result1 + "\"\n");

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("nums = " + Arrays.toString(nums2));
        String result2 = largestNumber(nums2);
        System.out.println("结果: \"" + result2 + "\"\n");

        int[] nums3 = {0, 0};
        System.out.println("nums = " + Arrays.toString(nums3));
        String result3 = largestNumber(nums3);
        System.out.println("结果: \"" + result3 + "\"\n");

        int[] nums4 = {1, 20, 23, 4, 8};
        System.out.println("nums = " + Arrays.toString(nums4));
        String result4 = largestNumber(nums4);
        System.out.println("结果: \"" + result4 + "\"\n");
    }
}
