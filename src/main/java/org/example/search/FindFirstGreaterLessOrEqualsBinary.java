package org.example.search;

/**
 * 查找第一个大于等于给定值的元素
 * 查找第一个小于等于给定值的元素
 */
public class FindFirstGreaterLessOrEqualsBinary {

    /**
     * 查找第一个大于等于给定值的元素
     */
    public static int findFirstGreaterOrEqualsBinary(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= val) {
                // 对于 a[mid] 大于等于给定值 value 的情况，
                // 我们要先看下这个 a[mid] 是不是我们要找的第一个值大于等于给定值的元素。
                // 如果 a[mid] 前面已经没有元素，或者前面一个元素小于要查找的值 value，那 a[mid] 就是我们要找的元素。
                if (mid == 0 || arr[mid - 1] < val) {
                    return mid;
                } else {
                    // 如果 a[mid-1] 也大于等于要查找的值 value，
                    // 那说明要查找的元素在 [low, mid-1] 之间，所以，我们将 high 更新为 mid-1。
                    high = mid - 1;
                }
            } else {
                // 如果 a[mid] 小于要查找的值 value，那要查找的值肯定在 [mid+1, high] 之间，所以，我们更新 low=mid+1。
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个小于等于给定值的元素
     */
    public static int findFirstLessOrEqualsBinary(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                if (mid == arr.length - 1 || arr[mid + 1] > val) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 10};
        System.out.println(findFirstGreaterOrEqualsBinary(arr, 5));
        System.out.println(findFirstLessOrEqualsBinary(arr, 5));
    }

}
