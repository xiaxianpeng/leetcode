package org.example.linkedList.reverse;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/22 12:19 AM
 * 反转链表前 N 个节点
 * https://labuladong.github.io/algo/2/17/17/#二反转链表前-n-个节点
 */
public class ReverseN {

    /**
     * 后驱节点
     */
    ListNode successor = null;

    /**
     * @param head head
     * @return // 将链表的前 n 个节点反转（n <= 链表长度），返回新的头节点
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n+1 个节点
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ReverseN reverseN = new ReverseN();
        ListNode listNode = reverseN.reverseN(head, 2);
        System.out.println(listNode);
    }
}
