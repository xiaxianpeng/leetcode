package org.example.sort;

import java.util.Arrays;
import sun.dc.pr.PRError;

/**
 * Created by xianpeng.xia
 * on 2020/10/2 11:26 上午
 */
public class RadixSort {

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        // 最大位数
        int maxDigit = findMaxDigit(arr);

        for (int i = 0; i < maxDigit; i++) {
            // 除数
            int division = (int) Math.pow(10, i);

            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / division % 10;
                System.out.println("num " + num);
                count[num]++;
            }

            System.out.println("count: ");
            SortUtil.print(count);

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }
            System.out.println("count: ");
            SortUtil.print(count);

            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }
            System.out.println("result");
            SortUtil.print(result);
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
        //

        return result;
    }

    private static int findMaxDigit(int[] arr) {
        int maxValue = findMaxValue(arr);
        int digit = getDigit(maxValue);
        return digit;
    }

    private static int findMaxValue(int[] arr) {
        int maxValue = 0;
        for (int i : arr) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    private static int getDigit(int value) {
        if (value == 0) {
            return 1;
        }
        int digit = 0;
        for (int temp = value; temp != 0; temp = temp / 10) {
            digit++;
        }
        return digit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{421, 240, 115, 532, 305, 430, 124};
        int[] sort = sort(arr);
    }
}
