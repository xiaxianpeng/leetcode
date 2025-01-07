package org.example.linkedlist.reverse;

import org.example.linkedlist.structure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * Created on 2024/11/22 17:19
 */
public class SwapPairs {

    /**
     * 两两交换链表中的相邻节点
     *
     * @param head 链表的头节点
     * @return 交换后的链表头节点
     * 解题思路：
     * 使用一个虚拟头节点 dummy 作为链表的新头节点，方便处理边界条件。
     * 使用一个指针 curr 遍历链表，每次交换两个相邻节点的指针指向。
     * 具体步骤：curr 节点指向的第一个节点与第二个节点交换位置，curr 然后跳过两个节点，继续进行下一个交换。
     * 直到链表末尾。
     */
    public static ListNode swapPairs(ListNode head) {
        // 创建一个虚拟头节点，简化处理边界情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // curr 是当前处理的节点，初始化为虚拟头节点
        ListNode curr = dummy;

        // 遍历链表，直到链表末尾
        while (curr.next != null && curr.next.next != null) {
            // first指向要交换的第一个节点
            ListNode first = curr.next;
            // second指向要交换的第二个节点
            ListNode second = curr.next.next;

            // 下面三步实现两两交换
            // 1、将curr.next指向second
            curr.next = second;
            // 2、将first.next指向second.next
            first.next = second.next;
            // 3、将second.next指向first
            second.next = first;

            // curr向后移动两个节点，准备下一轮交换
            curr = first;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        //  输入: [1,2,3,4], 输出: [2,1,4,3]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println("Initial list: " + head1);
        ListNode result1 = swapPairs(head1);
        System.out.println("After swapping pairs: " + result1);

        //  输入: [], 输出: []
        ListNode head2 = null;
        System.out.println("Initial list: " + head2);
        ListNode result2 = swapPairs(head2);
        System.out.println("After swapping pairs: " + result2);

        //  输入: [1], 输出: [1]
        ListNode head3 = new ListNode(1);
        System.out.println("Initial list: " + head3);
        ListNode result3 = swapPairs(head3);
        System.out.println("After swapping pairs: " + result3);
    }
}
