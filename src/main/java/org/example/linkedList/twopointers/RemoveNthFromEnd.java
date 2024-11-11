package org.example.linkedList.twopointers;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 8:35 PM
 * 19. 删除链表的倒数第N个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚拟头节点，这样对头节点的处理就和其他节点一致
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 删除倒数第 n 个节点，要先找到倒数第 n+1 个节点
        ListNode x = findFromEnd(dummy, n + 1);

        // 删除倒数第 n 个节点
        x.next = x.next.next;
        // 返回链表的新头节点，即虚拟头节点的下一个节点
        return dummy.next;
    }

    private static ListNode findFromEnd(ListNode head, int n) {
        // 初始化两个指针，都指向头节点
        ListNode p1 = head;
        ListNode p2 = head;
        // p1 先向前移动 n 步
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        // 当 p1 不为 null 时，p1 和 p2 同时向前移动
        // 当 p1 移动到链表末尾时，p2 就指向了倒数第 n 个节点
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 返回 p2，即倒数第 n 个节点
        return p2;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        System.out.println(head);
        ListNode listNode = removeNthFromEnd(head, k);
        System.out.println(listNode);
    }
}
