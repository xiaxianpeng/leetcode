package org.example.search;

import org.example.bean.Person;

/**
 * @author xianpeng.xia
 * on 2021/1/17 12:08 下午
 *
 * 线性查找
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("数据为空");
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int index = LinearSearch.search(data, 16);
        System.out.println(index);

        Person[] personList = {new Person("A"), new Person("B"), new Person("C")};
        Person personA = new Person("A");
        index = LinearSearch.search(personList, personA);
        System.out.println(index);

    }
}
