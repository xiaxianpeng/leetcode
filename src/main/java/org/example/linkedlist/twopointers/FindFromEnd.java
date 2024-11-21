package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 8:25 PM
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * * <p>
 * * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * * <p>
 * * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * * 返回链表 4->5.
 */
public class FindFromEnd {

    /**
     * @param head head
     * @param k k
     * @return 输出链表中倒数第k个节点
     * 果用 big O 表示法来计算时间复杂度，
     * 无论遍历一次链表和遍历两次链表的时间复杂度都是 O(N)，
     */
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n-k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        int k = 2;
        ListNode fromEnd = findFromEnd(head, k);
        System.out.println(fromEnd);
    }
}
