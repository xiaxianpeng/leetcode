package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/3/30 12:38 PM
 *
 * * 旋转排序数组中找目标值
 *
 * 法二：在英文版看到了一个有意思的思路。
 * 对于旋转数组 nums = [4,5,6,7,0,1,2]
 * 首先根据 nums[0] 与 target 的关系判断 target 是在左段还是右段。
 *
 * 例如 target = 5, 目标值在左半段，因此在 [4, 5, 6, 7, inf, inf, inf] 这个有序数组里找就行了；
 * 例如 target = 1, 目标值在右半段，因此在 [-inf, -inf, -inf, -inf, 0, 1, 2] 这个有序数组里找就行了。
 * 如此，我们又双叒叕将「旋转数组中找目标值」 转化成了 「有序数组中找目标值」
 */
public class SearchFromRotateArray {

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据num[0]与target的关系判断目标值是在左半段还是右半段
            if (target >= nums[0]) {
                // 目标值在左半段，若mid的在右半段，则将mid索引改成inf
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 如果目标值在右半段，若目标值在左半段，则将mid索引值改成-inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            // 二分查找
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int index = search(nums, 7);
        System.out.println(index);
    }

}
