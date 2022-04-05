package org.example.linkedList;

/**
 * @author xianpeng.xia
 * on 2021/12/13 11:59 下午
 *
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * https://labuladong.gitee.io/algo/2/17/16/#两个链表是否相交
 *
 * 弄这么多字也没讲明白。
 * 若相交，链表A： a+c, 链表B : b+c.
 * a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。
 * 若不相交，a + b = b + a 。因此相遇处是NULL
 */
public class GetIntersectionNode {

    public static ListNode intersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : p2;
            p2 = p2 != null ? p2.next : p1;
        }
        return p1;
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1指向A链表的头节点，p2指向B链表的头节点，
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // P1走一步，如果走到A链表的末尾，转向B链表
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            // p2走一步，如果走到B链表的末尾，转向A链表
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        // 相交点
        return p1;
    }

    public static void main(String[] args) {

        ListNode listNodeA = new ListNode(new int[]{1, 9, 1});
        ListNode listNodeB = new ListNode(new int[]{3});
        ListNode listNodeC = new ListNode(new int[]{2, 4});
        listNodeA.next = listNodeC;
        listNodeB.next = listNodeC;

        ListNode intersectionNode = intersectionNode(listNodeA, listNodeB);
        System.out.println(intersectionNode);
    }
}
