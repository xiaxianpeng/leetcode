package org.example.linkedlist;

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
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 * Created on 2024/11/22 17:19
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 定义要交换的两个节点
        ListNode first = head;
        ListNode second = head.next;
        // 打印当前待交换的节点值
        System.out.println("Swapping: " + first.val + " and " + second.val);

        // 递归交换后续节点
        ListNode swappedRest = swapPairs(second.next);

        // 进行交换
        first.next = swappedRest;
        second.next = first;

        // 返回新头节点
        return second;
    }

        public static void main(String[] args) {
            ListNode head = new ListNode(new int[]{1,2,3,4,5,6,7,8});
            System.out.println(head);

            ListNode swappedHead = swapPairs(head);
            System.out.println(swappedHead);
    }
}
