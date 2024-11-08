package org.example.divideandconquer;

/**
 * LCR 170. 交易逆序对的总数
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。
 * 请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 * 示例 1:
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 * Created on 2024/11/8 11:28
 */
public class ReversePairs {
    int count = 0;

    /**
     * 归并排序」与「逆序对」是息息相关的。归并排序体现了 “分而治之” 的算法思想，具体为：
     * 分： 不断将数组从中点位置划分开（即二分法），将整个数组的排序问题转化为子数组的排序问题；
     * 治： 划分到子数组长度为 1 时，开始向上合并，不断将 较短排序数组 合并为 较长排序数组，直至合并至原数组时完成排序；
     * 链接：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solutions/622496/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
     */
    public int reversePairs(int[] record) {
        this.count = 0;
        mergeSort(record, 0, record.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        //当只有一个节点的时候，直接返回，退出递归
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        // 左拆分
        mergeSort(nums, left, mid);
        // 右拆分
        mergeSort(nums, mid + 1, right);
        // 合并
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        //定义一个临时数组
        int[] temp = new int[right - left + 1];
        //定义一个指针，指向第一个数组的第一个元素
        int i = left;
        //定义一个指针，指向第二个数组的第一个元素
        int j = mid + 1;
        //定义一个指针，指向临时数组的第一个元素
        int t = 0;
        while (i <= mid && j <= right) {
            //比较两个数组的元素，取较小的元素加入到，临时数组中
            //并将两个指针指向下一个元素
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                //当 nums[i] > nums[j] 时，由于左子数组和右子数组都是排序好的，
                //我们知道从左子数组的当前位置 i 到中间位置 mid 的所有数都会和 nums[j] 形成逆序对。此时这个数就是，逆序数
                //定义一个计数器，记下每次合并中存在的逆序数。
                count += mid - i + 1;
                temp[t++] = nums[j++];
            }
        }

        // 当左边的数组没有遍历完成时，直接将剩余元素加入到临时数组中
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        //当右边的数组没有遍历完成后，直接将剩余元素加入到临时数组中
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        //将新数组中的元素，覆盖nums旧数组中的元素。
        //此时数组的元素已经是有序的
        for (int k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] record = {9, 7, 5, 4, 6};
        System.out.println(new ReversePairs().reversePairs(record));
    }
}
