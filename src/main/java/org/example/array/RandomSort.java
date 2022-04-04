package org.example.array;

import java.util.Random;
import org.example.sort.SortUtil;

/**
 * @author xianpeng.xia
 * on 2022/4/2 11:54 AM
 *
 * 将1-100的整数乱序输出
 */
public class RandomSort {

    public static void randomSort(int[] arr) {
        int[] temp = arr.clone();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == temp[i]) {
                ////与原数组元素相等，说明未改变位置
                change(temp, arr, i);
            }
        }
    }

    private static void change(int[] original, int[] arr, int target) {
        int size = arr.length;
        int[] indexes = getIndexesWithout(size, target);
        int temp = arr[target];

        Random random = new Random();

        // 尝试交换的元素下标
        int randomInt = random.nextInt(size - 1);
        int index = indexes[randomInt];

        System.out.println("index = " + index);

        if (arr[index] == original[index]) {
            //与原数组元素相等，未变位置，可以交换
            arr[target] = arr[index];
            arr[index] = temp;
        } else {
            //若选中的元素是已经更换位置的，则继续尝试与数组中的其它元素交换位置
            for (int i = 0; i < size && i != index && i != target; i++) {
                if (arr[i] == original[i]) {
                    arr[target] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }

    /**
     * 获取下标之外的下标
     */
    private static int[] getIndexesWithout(int size, int targetIndex) {
        int[] indexesWithout = new int[size - 1];
        for (int i = 0; i < size; i++) {
            if (i != targetIndex) {
                if (i < targetIndex) {
                    indexesWithout[i] = i;
                } else {
                    indexesWithout[i - 1] = i;
                }
            }
        }
        return indexesWithout;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        SortUtil.print(arr);
        randomSort(arr);
        SortUtil.print(arr);
    }
}
