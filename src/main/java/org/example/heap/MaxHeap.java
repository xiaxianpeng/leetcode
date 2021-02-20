package org.example.heap;

import java.util.Random;
import org.example.array.Array;

/**
 * @date 2021/02/19
 * @time 15:13
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap(E[] data) {
        this.data = new Array<>(data);
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引
     */
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
     */
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
     */
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    private E findMax() {
        if (size() == 0) {
            throw new IllegalArgumentException("Can not findMax when heep is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            int rightChild = rightChild(k);
            if (rightChild < data.getSize() && data.get(rightChild).compareTo(data.get(j)) > 0) {
                j = rightChild;
            }
            // data[j] 是leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出最大元素,并替换成元素e
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error.");
            }
        }
        System.out.println("Test MaxHeap completed");
    }
}
