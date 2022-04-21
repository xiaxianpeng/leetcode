package org.example.linkedList.reverse;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/22 12:43 AM
 *
 * 反转链表的一部分
 *
 * https://labuladong.github.io/algo/2/17/17/#三反转链表的一部分
 */
public class ReverseBetween {

    /**
     * 后驱节点
     */
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reserveN(head, n);
        }
        return reverseBetween(head.next, m - 1, n - 1);
    }

    private ListNode reserveN(ListNode head, int n) {
        if (n == 1) {
            // 记录 n+1 个节点
            successor = head.next;
            return head;
        }
        ListNode last = reserveN(head.next, n - 1);
        head.next.next = head;
        // 让反转后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        int m = 1, n = 3;

        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode ans = reverseBetween.reverseBetween(head, m, n);
        System.out.println(ans);
    }
}
