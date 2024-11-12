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
     * @param node head
     * @return // 将链表的前 n 个节点反转（n <= 链表长度），返回新的头节点
     */
    public ListNode reverseN(ListNode node, int n) {
        // 递归终止条件：如果 n 为 1，表示要反转的节点只有一个，或者已经到达要反转的最后一个节点
        if (n == 1) {
            // 记录第 n+1 个节点，此节点会成为反转部分的尾节点的下一个节点
            successor = node.next;
            return node;
        }
        // 递归反转 head.next 为头的链表的前 n - 1 个节点
        ListNode last = reverseN(node.next, n - 1);
        // 反转当前节点 head 与下一个节点的指向关系
        node.next.next = node;
        // 让反转之后的 head 节点和后面的节点（即第 n+1 个节点）连起来
        node.next = successor;
        // 返回反转后的头节点
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ReverseN reverseN = new ReverseN();
        ListNode listNode = reverseN.reverseN(head, 2);
        System.out.println(listNode);
    }
}
