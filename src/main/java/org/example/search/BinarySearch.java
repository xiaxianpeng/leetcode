package org.example.search;

import org.example.util.ArrayGenerator;

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
        int l = 0;
        int r = data.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                // target在右侧
                l = mid + 1;
            } else {
                // target在左侧
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateOrderedArray(10);
        int index = nonRecursiveSearch(data, 5);
        System.out.println("index = " + index);
    }
}
