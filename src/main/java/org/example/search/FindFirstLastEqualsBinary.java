package org.example.search;

/**
 * 查找第一个值等于给定值的元素
 */
public class FindFirstLastEqualsBinary {

    public static int findFirstEqualsBinary(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            //  防止溢出
            int mid = low + (high - low) / 2;
            if (arr[mid] > val) {
                // 对于 a[mid]>value 的情况，我们需要更新 high= mid-1；
                high = mid - 1;
            } else if (arr[mid] < val) {
                // 对于 a[mid]<value 的情况，我们需要更新 low=mid+1
                low = mid + 1;
            } else {
                // 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
                // 如果 mid 不等于 0，但 a[mid] 的前一个元素 a[mid-1] 不等于 value，那也说明 a[mid] 就是我们要找的第一个值等于给定值的元素。
                if (mid == 0 || arr[mid - 1] != val) {
                    return mid;
                } else {
                    // 否则，继续在左侧部分搜索
                    high = mid - 1;
                }
            }
        }
        // // 如果没有找到，返回-1
        return -1;
    }

    public static int findLastEqualsBinary(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            //  防止溢出
            int mid = low + (high - low) / 2;
            if (arr[mid] > val) {
                // 对于 a[mid]>value 的情况，我们需要更新 high= mid-1；
                high = mid - 1;
            } else if (arr[mid] < val) {
                // 对于 a[mid]<value 的情况，我们需要更新 low=mid+1
                low = mid + 1;
            } else {
                // 如果 a[mid] 这个元素已经是数组中的最后一个元素了，那它肯定是我们要找的；
                // 如果 a[mid] 的后一个元素 a[mid+1] 不等于 value，那也说明 a[mid] 就是我们要找的最后一个值等于给定值的元素。
                if (mid == arr.length - 1 || arr[mid + 1] != val) {
                    return mid;
                } else {
                    // 如果我们经过检查之后，发现 a[mid] 后面的一个元素 a[mid+1] 也等于 value，
                    // 那说明当前的这个 a[mid] 并不是最后一个值等于给定值的元素。
                    // 我们就更新 low=mid+1，因为要找的元素肯定出现在 [mid+1, high] 之间。
                    low = mid + 1;
                }
            }
        }
        // // 如果没有找到，返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 3, 3, 4, 5, 5, 6};
        System.out.println(findFirstEqualsBinary(sortedArray, 3));
        System.out.println(findLastEqualsBinary(sortedArray, 3));
    }
}
