package org.example.linkedList;

import org.example.bean.ListNode;

/**
 * @date 2020/09/25
 * @time 12:54
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class KthFromEnd {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.getNextNode();
        }
        while (former != null) {
            former = former.getNextNode();
            latter = latter.getNextNode();
        }
        return latter;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);
        ListNode sixthNode = new ListNode(6);

        headNode.setNextNode(secondNode);
        secondNode.setNextNode(thirdNode);
        thirdNode.setNextNode(fourthNode);
        fourthNode.setNextNode(fifthNode);
        fifthNode.setNextNode(sixthNode);

        ListNode kthFromEnd = getKthFromEnd(headNode, 2);
        System.out.println(kthFromEnd);
    }
}
