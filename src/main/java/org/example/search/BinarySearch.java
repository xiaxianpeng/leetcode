package org.example.search;

import org.example.util.ArrayUtil;

/**
 * @author xianpeng.xia
 * on 2021/2/1 12:01 上午
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        return search(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int search(E[] data, int l, int r, E target) {
        if (l > r) {
            return -1;
        }
        int mid = (r - l) / 2 + l;

        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            // target在右侧
            return search(data, mid + 1, r, target);
        } else {
            // target在左侧
            return search(data, l, mid - 1, target);
        }
    }

    /**
     * 非递归实现二分查找法
     */
    public static <E extends Comparable<E>> int nonRecursiveSearch(E[] data, E target) {
        int L = 0;
        int R = data.length - 1;
        // 因为初始化 right 的赋值是 nums.length - 1，[left, right] 其实就是每次进行搜索的区间。所以 L <= R
        while (L <= R) {
            int mid = (R - L) / 2 + L;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            // 本算法的搜索区间是两端都闭的，即 [left, right]。
            // 那么当我们发现索引 mid 不是要找的 target 时，下一步应该去搜索去搜索区间 [left, mid-1] 或者区间 [mid+1, right]
            // 因为 mid 已经搜索过，应该从搜索区间中去除。
            if (data[mid].compareTo(target) < 0) {
                // target在右侧
                L = mid + 1;
            } else {
                // target在左侧
                R = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayUtil.generateOrderedArray(10);
        int index = nonRecursiveSearch(data, 5);
        System.out.println("index = " + index);
    }
}
