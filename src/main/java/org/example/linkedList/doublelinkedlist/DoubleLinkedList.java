package org.example.linkedList.doublelinkedlist;

/**
 * @author xianpeng.xia
 * on 2022/4/1 5:21 PM
 * 双向链表
 */
public class DoubleLinkedList {

    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;

    public DoubleLinkedList() {
        // 初始化双向链表的数据
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    /**
     * // 在链表尾部添加节点 x，时间 O(1)
     */
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;

        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    /**
     * // 删除链表中的 x 节点（x ⼀定存在）
     * // 由于是双链表且给的是⽬标 Node 节点，时间 O(1)
     */
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    /**
     * // 删除链表中第⼀个节点，并返回该节点，时间 O(1)
     */
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public boolean removeByKey(int key) {
        // 从头节点开始遍历
        Node current = head.next;
        while (current != tail) { // 遍历直到尾虚节点
            if (current.key == key) { // 找到了要删除的节点
                // 从链表中移除当前节点
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--; // 更新链表大小
                return true; // 删除成功，返回 true
            }
            current = current.next; // 移动到下一个节点
        }
        return false; // 未找到具有给定 key 的节点
    }

    /**
     * // 返回链表⻓度，时间 O(1
     */
    public int size() {
        return size;
    }

    public void print() {
        Node current = head.next; // 从第一个实际存储数据的节点开始
        System.out.print("NULL <-> ");
        while (current != tail) { // 遍历链表直到尾虚节点
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // 创建双向链表实例
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // 创建并添加节点
        doubleLinkedList.addLast(new Node(1, 1));
        doubleLinkedList.addLast(new Node(2, 2));
        doubleLinkedList.addLast(new Node(3, 3));
        // 打印链表
        doubleLinkedList.print(); // 应该输出 "NULL <-> 1 <-> 2 <-> 3 <-> NULL"
        doubleLinkedList.removeByKey(2);
        doubleLinkedList.print(); // 应该输出 "NULL <-> 1 <-> 3 <-> NULL"
    }
}
