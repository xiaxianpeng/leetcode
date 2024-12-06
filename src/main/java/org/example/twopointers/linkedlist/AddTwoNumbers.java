package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    /**
     * 给定两个链表 l1 和 l2，表示两个逆序存储的非负整数，返回它们的和，也以链表形式存储。
     * 核心策略：使用两个指针分别遍历两个链表，逐位相加，处理进位，最终返回结果链表。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后的链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummyHead = new ListNode(0);
        // 指针p负责构建新链表
        ListNode p = dummyHead;
        // 在两条链表上的指针
        ListNode p1 = l1;
        ListNode p2 = l2;
        // 进位
        int carry = 0;

        // 执行加法，两条链表走完且没有进位才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 当前位的和
            int sum = carry;

            // 如果 p1 不为空，则加上 p1 当前位的数字
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;// 移动p1
            }

            // 如果 p2 不为空，则加上 p2 当前位的数字
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;// 移动p2
            }

            // 更新进位，当前位的和可能大于或等于 10
            carry = sum / 10;
            // 余数，当前位的结果
            int remainder = sum % 10;

            // 创建一个新节点存储当前位的结果
            p.next = new ListNode(remainder);
            p = p.next;
        }

        // 返回结果链表（跳过虚拟头节点）
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        // 342 + 465 = 807
        System.out.println(l1);
        System.out.println(l2);

        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println(sum);

    }
}
