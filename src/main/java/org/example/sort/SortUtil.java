package org.example.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 11:56 上午
 */
public class SortUtil {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static <E> void print(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            int n = random.nextInt(10000);
            arr[i] = n;
        }
        return arr;
    }

    public static void check(int[] array, int[] array2) {
        Arrays.sort(array);
        boolean same = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array2[i]) {
                same = false;
            }
        }
        System.out.println("Same " + same);
    }
}
