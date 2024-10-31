package org.example.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSort {

    public static void bucketSort(int[] arr, int maxVal) {
        // 计算桶的数量，可根据需要调整，这里我们简单地使用数组的最大值加1作为桶的数量
        int bucketCount = maxVal + 1;

        // 创建一个桶的列表
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        // 初始化桶，每个桶都是一个空列表
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 遍历输入数组，将每个元素放入相应的桶中
        // 桶的编号即为元素的值
        for (int elem : arr) {
            buckets.get(elem).add(elem);
        }

        // 对每个桶进行排序，可以使用任何排序方法，这里使用的是Collections.sort()
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 合并桶，将所有桶中的元素按顺序放回原数组
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int elem : bucket) {
                arr[index++] = elem;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        bucketSort(arr, 9);
        SortUtil.print(arr);
    }
}
