package org.example.twopointers.linkedlist;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 11:16 PM
 * 给你两个单链表的头节点headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 自定义评测：
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。
 * 如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 */
public class IntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果任意一个链表为空，则不可能相交
        if (headA == null || headB == null) {
            return null;
        }
        // 初始化两个指针分别指向两个链表的头节点
        ListNode pA = headA;
        ListNode pB = headB;
        // 遍历两个链表，直到两个指针相遇或同时到达链表末尾（null）
        while (pA != pB) {
            // 如果 p1 到达链表末尾，重定向到链表 B 的头节点
            pA = pA.next != null ? pA.next : headB;
            // 如果 pB 到达链表末尾，重定向到链表 A 的头节点
            pB = pB.next != null ? pB.next : headA;
        }
        // 如果链表相交，pA 将是相交的起始节点；如果不相交，pA 将是 null
        return pA;
    }

    public static void main(String[] args) {
        ListNode intersectionNode = new ListNode(new int[]{7, 8, 9});
        ListNode L1 = new ListNode(new int[]{1, 2, 3});
        ListNode L2 = new ListNode(new int[]{4, 5, 6});
        L1.next = intersectionNode;
        L2.next = intersectionNode;

        ListNode node = getIntersectionNode(L1, L2);
        System.out.println(node);
    }
}
