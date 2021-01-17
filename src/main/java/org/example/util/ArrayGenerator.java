package org.example.util;

/**
 * @author xianpeng.xia
 * on 2021/1/17 2:16 下午
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

}
