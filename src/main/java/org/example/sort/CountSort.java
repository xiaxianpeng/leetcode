package org.example.sort;

/**
 * Created by xianpeng.xia
 * on 2020/10/2 10:01 上午
 *
 * 计数排序
 * 适合量大范围小的排序
 *
 * 比如高考名次，年龄排序
 *
 * 1 找出带排序的数组最大和最小的元素
 * 2 统计数组中每个值出现的次数，存入数组的第一项
 * 3 对所有的计数累加
 * 4 反向填充目标数组
 */
public class CountSort {

    public static int[] sort(int[] arr, int bucketLength) {
        int[] result = new int[arr.length];
        int[] count = new int[bucketLength];

        // 计数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println("count : ");
        SortUtil.print(count);
        //累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println("count : ");
        SortUtil.print(count);
        //
        SortUtil.print(result);
        for (int i = arr.length - 1; i >= 0; i--) {
            // arr[i] -> 它的位置
            result[--count[arr[i]]] = arr[i];
            SortUtil.print(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        sort(arr, 10);
    }
}
