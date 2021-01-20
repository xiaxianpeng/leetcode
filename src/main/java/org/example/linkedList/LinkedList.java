package org.example.linkedList;

/**
 * @date 2021/01/20
 * @time 14:58
 */
public class LinkedList<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 往链表中间添加新的元素
     */
    public void add(int index, E e) {
        // 关键是找到要添加的节点的前一个节点
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 往链表头添加新的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 往链表尾添加新的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取位置为index的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     */
    public E getLast() {
        return get(size);
    }

    /**
     * 修改索引为index的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed,illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在元素e
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表的第index个元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed,index illegal.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e + " -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);

        linkedList.add(2, 88);
        System.out.println(linkedList);

        boolean contains = linkedList.contains(1);
        System.out.println("contains : " + contains);

        Integer integer = linkedList.get(5);
        System.out.println("get : " + integer);

        Integer remove = linkedList.remove(2);
        System.out.println("remove : " + remove);
        System.out.println(linkedList);

    }
}

