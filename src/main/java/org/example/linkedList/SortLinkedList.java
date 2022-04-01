package org.example.linkedList;

/**
 * @author xianpeng.xia
 * on 2022/4/1 9:41 AM
 * 对单链表排序
 */
public class SortLinkedList {

    /**
     * 插入排序
     *
     * @param head 头
     * @return 排序后的链表
     */
    public static ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // pre 指向已经有序的节点
        ListNode pre = head;
        // cur指向待排序的节点
        ListNode cur = head.next;
        // 辅助节点
        ListNode aux = new ListNode(-1);
        aux.next = head;

        while (cur != null) {
            if (cur.val < pre.val) {
                // 先将cur节点从当前链表删除，再将cur节点放到合适的位置
                pre.next = cur.next;
                // 从后往前找到l2.val>cur.val,然后将cur节点插入到l1和l2之间
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }
                // 将cur节点插入到l1和l2之间
                l1.next = cur;
                cur.next = l2;
                // 指向下一个待处理节点
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }

    /**
     * 归并排序
     *
     * @param head 头
     * @return 排序后的链表
     */
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        // 将链表从中分为两个链表,head和tail
        ListNode tail = mid.next;
        mid.next = null;
        // 对两个链表排序
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(tail);
        return merge(left, right);
    }

    /**
     * 两个链表归并
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        // 辅助节点,排好序的节点将链接到dummy后面
        ListNode dummy = new ListNode(-1);
        // tail指向最后一个排好序的节点
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
    }

    /**
     * 返回链表的中间节点
     */
    private static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 快速排序
     *
     * @param head 头
     * @return 排序后的链表
     */
    public static ListNode quickSort(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    private static ListNode partition(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;
        while (p2 != end) {
            // 大于key值时，p1向前走一步，交换p1和p2的值
            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }
        // 当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{2, 4, 1, 3, 5, 2, 8});

        //插入排序
        // System.out.println(insertionSort(head));

        // 归并排序
        //System.out.println(mergeSort(head));

        // 快速排序
        System.out.println(quickSort(head));
    }
}
