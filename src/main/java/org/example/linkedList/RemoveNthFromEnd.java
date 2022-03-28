package org.example.linkedList;

/**
 * @Author xiapeng
 * @Date: 2022/03/28/3:01 下午
 * @Description:
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第N个结点
 * 快慢指针的应用
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第n个，先找到倒数第n+1个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删除倒数第k个节点
        x.next = x.next.next;
        return dummy.next;
    }

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // p1，p2同时走n-k步
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // 现在p2指向第n-k个节点
        return p2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode listNode = solution.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
}
