package org.example.linkedList.reverse;

import org.example.linkedList.structure.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 反转链表的一部分
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 使用 dummy node 来简化边界条件的处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 初始化指针，找到左侧节点的前一个节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 开始节点就是 prev 的下一个节点
        ListNode curr = prev.next;
        // 开始进行反转操作
        for (int i = 0; i < right - left; i++) {
            // next 指向当前节点 curr 的下一个节点
            ListNode next = curr.next;
            // 将当前节点 curr 的下一个指向 next 的下一个节点，
            // 实际上将 next 从链表中暂时拿出
            curr.next = next.next;
            // 将 next 插入到已经反转的部分的前面，
            // prev.next 是反转部分的头节点
            next.next = prev.next;
            // 更新 prev，将 next 节点移动到前面，成为新的头节点
            prev.next = next;
        }
        // 返回反转后的链表的头节点
        return dummy.next;
    }

    // ***********以下是递归方式***********
    /**
     * 后驱节点
     */
    ListNode successor = null;

    public ListNode reverseLinkedList(ListNode head, int left, int right) {
        // base case: 当 left 为 1 时，开始反转前 right 个节点
        if (left == 1) {
            return reserveN(head, right);
        }
        // 递归地将 left 和 right 向前移动，直到 left 为 1
        head.next = reverseLinkedList(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reserveN(ListNode head, int n) {
        if (n == 1) {
            // 记录 n+1 个节点
            successor = head.next;
            return head;
        }
        // 递归反转头节点的下一个节点开始的链表的前 n-1 个节点
        ListNode last = reserveN(head.next, n - 1);
        // 反转当前节点 head 与其下一个节点的指向
        head.next.next = head;
        // 连接反转后的链表的最后一个节点与后续部分
        head.next = successor;
        // 返回反转后的链表头节点
        return last;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        int left = 1, right = 3;

        System.out.println(new ReverseBetween().reverseLinkedList(head, left, right));

        head = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new ReverseBetween().reverseBetween(head, left, right));
    }
}
