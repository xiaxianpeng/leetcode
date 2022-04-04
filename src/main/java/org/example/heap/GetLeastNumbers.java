package org.example.heap;


import java.util.PriorityQueue;
import org.example.sort.SortUtil;

/**
 * @author xianpeng.xia
 * on 2022/4/4 4:39 PM
 *
 * 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class GetLeastNumbers {

    public static int[] getLeastNumbers(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        // 需要在最大堆中存k个最小元素
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            // 比较num[i]与堆顶元素，如果小于堆顶元素，就插入堆
            Integer max = pq.peek();
            if (nums[i] < max) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        // 遍历pq
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        int[] leastNumbers = getLeastNumbers(arr, 2);
        SortUtil.print(leastNumbers);
    }
}
