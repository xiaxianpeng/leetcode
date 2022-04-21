package org.example.linkedList.twopointers;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 11:16 PM
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetIntersectionNode {

    /**
     * @param L1 l1
     * @param L2 l2
     * @return 相交链表
     *
     * * 弄这么多字也没讲明白。
     * * 若相交，链表A： a+c, 链表B : b+c.
     * * a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。
     * * 若不相交，a + b = b + a 。因此相遇处是NULL
     */
    public static ListNode getIntersectionNode(ListNode L1, ListNode L2) {
        ListNode p1 = L1, p2 = L2;
        while (p1 != p2) {
            p1 = p1.next != null ? p1.next : p2;
            p2 = p2.next != null ? p2.next : p1;
        }
        return p1;
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
