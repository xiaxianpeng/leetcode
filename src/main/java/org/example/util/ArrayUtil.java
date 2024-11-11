package org.example.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xianpeng.xia
 * on 2021/1/17 2:16 下午
 */
public class ArrayUtil {

    private ArrayUtil() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * @param n 数组长度
     * @param bound 上界
     * @return 长度为n, 数字范围是[0, bound)的数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}
