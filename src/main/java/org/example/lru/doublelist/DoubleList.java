package org.example.lru.doublelist;

/**
 * @author xianpeng.xia
 * on 2022/4/1 5:21 PM
 */
public class DoubleList {

    // 头尾虚节点
    private Node head, tail;
    // 链表元素数
    private int size;

    public DoubleList() {
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

    /**
     * // 返回链表⻓度，时间 O(1
     */
    public int size() {
        return size;
    }
}
