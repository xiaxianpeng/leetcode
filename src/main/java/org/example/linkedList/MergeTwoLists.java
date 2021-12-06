package org.example.linkedList;


/**
 * @author xianpeng.xia
 * on 2021/12/6 10:29 下午
 * 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    static ListNode solution(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较p1和p2的指针
            // 将值较小的节点接到p指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p指针不断前进
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 2, 4}), l2 = new ListNode(new int[]{1, 3, 4, 5});
        System.out.println(l1);
        System.out.println(l2);
        ListNode ret = solution(l1, l2);
        System.out.println(ret);
    }
}
