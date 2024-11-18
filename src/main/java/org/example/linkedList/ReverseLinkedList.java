package org.example.linkedList;


import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2021/1/22 10:57 下午
 * 链表反转
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        // 前指针节点
        ListNode prev = null;
        // 当前指针节点
        ListNode cur = head;
        // 每次循环，将当前节点指向它前面的节点
        // 然后当前节点和前节点后移
        while (cur != null) {
            // 临时节点，暂存当前节点的下一个节点，用于后移
            // cur.next = prev会断链
            ListNode next = cur.next;
            // 将当前节点指向它前面的节点
            cur.next = prev;
            // 前指针后移
            prev = cur;
            // 当前指针后移
            cur = next;
        }
        return prev;
    }

    public static ListNode reverseListNode(ListNode head) {
        // 最小子问题，结束
        if (head == null || head.next == null) {
            return head;
        }
        // 递归过程，一次次拆解问题
        ListNode rev = reverseListNode(head.next);
        // 反转
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        ListNode reverseList = reverseListNode(listNode);
        System.out.println(reverseList);
    }
}
