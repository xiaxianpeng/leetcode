package org.example.sort;

/**
 * Created by xianpeng.xia
 * on 2020/10/2 10:01 上午
 * <p>
 * 计数排序
 * 适合量大范围小的排序
 * <p>
 * 比如高考名次，年龄排序
 * <p>
 * 1 找出带排序的数组最大和最小的元素
 * 2 统计数组中每个值出现的次数，存入数组的第一项
 * 3 对所有的计数累加
 * 4 反向填充目标数组
 * *******
 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 * 而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 * *******
 * 比如，还是拿考生这个例子。如果考生成绩精确到小数后一位，我们就需要将所有的分数都先乘以 10，转化成整数，然后再放到 9010 个桶内。
 * 再比如，如果要排序的数据中有负数，数据的范围是 [-1000, 1000]，那我们就需要先对每个数据都加 1000，转化成非负整数。
 */
public class CountSort {

    public static int[] sort(int[] arr, int bucketLength) {
        // 创建一个结果数组 result，它将包含排序后的元素。
        int[] result = new int[arr.length];
        // 创建一个计数数组 count，其长度由 bucketLength 指定。bucketLength 应该足够大，以容纳输入数组 arr 中的最大值。
        int[] count = new int[bucketLength];

        // 计数阶段：遍历输入数组 arr，并对于数组 arr 中的每个值 arr[i]，将计数数组 count[arr[i]] 的值加一，以统计每个元素的出现次数。
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println("count : ");
        SortUtil.print(count);
        // 累加阶段：对计数数组进行累加操作。这是为了确定每个元素在结果数组中的位置。累加后的 count[i] 表示在排序数组中，有多少元素小于或等于值 i。
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println("count : ");
        SortUtil.print(count);
        //
        SortUtil.print(result);
        // 排序阶段：我们从输入数组 arr 的尾部开始进行反向遍历，这一做法能保证排序的稳定性。
        // 之所以能够保持稳定性，是因为在这种遍历方式下，原数组中后出现的相同元素会先被放置到结果数组中正确的位置上，
        // 然后计数数组相应的计数值会递减，使得接下来处理的相同元素能够被放置在前一个相同元素的前面。
        // 这样，原数组中先出现的相同元素在结果数组中的位置就会排在后出现的相同元素之前，维持了它们的原始相对顺序。
        for (int i = arr.length - 1; i >= 0; i--) {
            // 计算 arr[i] 在结果数组 result 中的索引位置。这个位置是基于 count 数组的累加值确定的，
            // 它表示直到 arr[i] 这个值为止（包含 arr[i]），在原数组中小于或等于 arr[i] 的元素数量。
            // 由于索引从 0 开始，需要减去 1。
            int index = count[arr[i]] - 1;
            // // 将元素 arr[i] 放置到结果数组 result 的计算出的位置上。
            result[index] = arr[i];
            // 完成放置后，更新计数数组。将 arr[i] 对应的计数减1，为下一个相同值的元素在结果数组中找到正确的位置。
            // 这实际上是在为后续相同值的元素腾出位置，确保相同元素在结果数组中的顺序和原数组中的顺序相同。
            count[arr[i]]--;
            SortUtil.print(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        sort(arr, 10);
    }
}
