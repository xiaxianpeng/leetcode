package org.example.array;

import org.example.sort.SortUtil;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定⼀个按照升序排列的整数数组 nums，和⼀个⽬标值 target，找出给定⽬标值在数组中的开始位置和结束位置。
 * 如果数组中不存在⽬标值 target，返回 [-1, -1]。
 * 示例 1：输⼊：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2： 输⼊：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 基本思路 PS：这道题在《算法⼩抄》 的第 71 ⻚。
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * ⼆分搜索的难点就在于如何搜索左侧边界和右侧边界，代码的边界的控制⾮常考验你的微操，
 */
public class SearchRange {

    public int[] solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 收缩右边界
                right = mid - 1;
            }
        }
        // 检查left越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩左边界
                left = mid + 1;
            }
        }
        // 检查right越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        SortUtil.print(searchRange.solution(nums, target));
        target = 6;
        SortUtil.print(searchRange.solution(nums, target));
        nums = new int[]{};
        target = 0;
        SortUtil.print(searchRange.solution(nums, target));
    }
}
