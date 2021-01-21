package org.example.array;

/**
 * @date 2021/01/21
 * @time 10:01
 */
public class ArraySum {

    private static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l...n)这个区间所有数字的和
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(sum(arr));
    }
}
