package org.example.sort;

import java.util.Arrays;

/**
 * Created by xianpeng.xia
 * on 2020/10/2 11:26 上午
 * 基数排序
 * 基数排序（Radix Sort）是一种非比较型整数排序算法，其基本思想是从整数的低位到高位，逐位进行排序。
 * 基数排序使用了桶（bucket）的概念，即将数据分布到若干个桶中，这些桶中的数据可以单独进行排序。
 * 基数排序的实现通常借助于其他稳定的排序算法，如计数排序或桶排序，来对每一位进行排序，保证了整体的稳定性。
 * 基数排序的原理可以分为以下几个步骤：
 * 1,找到最大数：首先确定待排序数组中最大数的位数，这个位数决定了需要进行的排序回合数。
 * 2,位排序：从最低位开始，对数组中的每个元素的相应位进行排序。可以采用计数排序等稳定排序算法来保证同一位数中的相对顺序。
 * 3,分配：根据当前位上的数字，将数组中的每个数分配到相应的桶中。例如，在个位数排序时，数字末尾是0的会被放到桶0中，末尾是1的会被放到桶1中，依此类推。
 * 4,收集：将桶中的数按桶的顺序收集起来，这样一来，数组中的数就根据当前位被排序了。收集后的数组用于下一位的排序。
 * 5,重复：对更高位重复分配和收集的过程，直到最高位。
 * 6,完成：经过最高位的排序后，数组就完成了整体排序。
 */
public class RadixSort {

    /**
     * 对数组 arr 进行基数排序
     *
     * @param arr 待排序的数组
     * @return 排序后的数组
     */
    public static int[] radixSort(int[] arr) {
        // 排序结果数组
        int[] result = new int[arr.length];
        // 计数数组，存放每一位数字0-9的出现次数
        int[] count = new int[10];
        // 最大位数
        int maxDigit = findMaxDigit(arr);

        // 按照从低位到高位的顺序进行排序处理
        for (int i = 0; i < maxDigit; i++) {
            // 计算当前位的除数，例如个位除数为1，十位除数为10
            int division = (int) Math.pow(10, i);
            // 计数阶段
            for (int j = 0; j < arr.length; j++) {
                // 从 arr[j] 中提取当前位的数字
                // division 是当前排序位的基数，例如对于个位 division 是 1，对于十位是 10
                int num = arr[j] / division % 10;
                // 在 count 数组的相应位置增加计数
                // num 是从 arr[j] 计算出的当前位的数字，它的范围是 0-9
                // 对应的 count[num] 就是这个数字的出现次数
                count[num]++;
            }

            // 累加计数数组，用于后续确定元素位置
            // 经过这个操作，count[m] 将表示数值 m 在最终排序数组中的结束位置索引
            for (int m = 1; m < count.length; m++) {
                // 对计数数组进行累加操作
                // count[m] 保存的是小于或等于 m 的元素的个数
                // 在累加后的数组中，count[m] 的值变为直到包含 m 的所有元素的个数
                count[m] += count[m - 1];
            }

            // 从数组的末尾开始向前遍历，这样可以保持之前位数排序时的稳定性
            for (int n = arr.length - 1; n >= 0; n--) {
                // 计算当前位的数字，例如个位、十位、百位等
                // division是当前位的除数，例如十位的除数是10
                int num = arr[n] / division % 10;
                // 计数数组 count[num] 保存了小于或等于当前数字 num 的元素数量
                // 因此，count[num] - 1 就是这个元素在结果数组中的位置
                // 然后将元素arr[n]放入结果数组，并将计数减一，为下一个相同的num腾出空间
                result[--count[num]] = arr[n];
            }

            // 将本轮排序后的结果拷贝回原数组 arr，为下一轮排序做准备
            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0); // 清空计数数组，为下一位数字的计数做准备
        }

        return result;
    }

    /**
     * 查找数组中最大数字的位数
     *
     * @param arr 数组
     * @return 最大位数
     */
    private static int findMaxDigit(int[] arr) {
        int maxValue = findMaxValue(arr); // 数组中的最大数值
        return getDigit(maxValue); // 最大数值的位数
    }

    /**
     * 查找数组中的最大数值
     *
     * @param arr 数组
     * @return 最大数值
     */
    private static int findMaxValue(int[] arr) {
        int maxValue = arr[0]; // 默认为数组第一个元素
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * 获取一个整数的位数
     *
     * @param value 整数值
     * @return 位数
     */
    private static int getDigit(int value) {
        if (value == 0) {
            return 1;
        }
        int digit = 0;
        for (int temp = value; temp != 0; temp /= 10) {
            digit++;
        }
        return digit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{421, 240, 115, 532, 305, 430, 124};
        int[] sortedArray = radixSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
