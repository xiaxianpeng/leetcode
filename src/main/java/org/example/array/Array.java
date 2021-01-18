package org.example.array;

/**
 * @author michael
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * @return 数组中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组尾添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组头添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向指定位置添加元素
     */
    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed,Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Require index >= 0 and index <= size.");
        }
        // 将index之后的元素向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取索引位置的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改索引位置的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 数组中是否存在元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组中元素e的索引,不存在返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除指定位置元素,返回被删除元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal.");
        }
        E e = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak
        data[size] = null;
        return e;
    }

    /**
     * 删除第一个元素,返回被删除元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素,返回被删除元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除元素e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Array: size = " + size + " , capacity = " + data.length);
        sb.append(" , [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);
    }
}
