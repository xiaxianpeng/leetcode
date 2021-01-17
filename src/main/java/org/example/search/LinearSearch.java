package org.example.search;

/**
 * @author xianpeng.xia
 * on 2021/1/17 12:08 下午
 *
 * 线性查找
 */
public class LinearSearch {

    public static int search(int[] data, int target) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("数据为空");
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int index = LinearSearch.search(data, 16);
        System.out.println(index);
    }
}
