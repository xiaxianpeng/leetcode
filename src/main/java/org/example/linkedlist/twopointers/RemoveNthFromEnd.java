package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * 19. 删除链表的倒数第N个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class RemoveNthFromEnd {

    /**
     * 删除链表的倒数第 N 个节点
     *
     * @param head 链表的头节点
     * @param n    倒数第 n 个节点
     * @return 修改后的链表的头节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个虚拟头节点，这样对头节点的处理就和其他节点一致
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 删除倒数第 n 个节点，要先找到倒数第 n+1 个节点
        ListNode prev = findFromEnd(dummy, n + 1);

        // 删除倒数第 n 个节点
        prev.next = prev.next.next;
        // 返回链表的新头节点，即虚拟头节点的下一个节点
        return dummy.next;
    }

    /**
     * 获取倒数第 k 个节点
     *
     * @param head 链表的头节点
     * @param k    倒数第 k 个节点
     * @return 倒数第 k 个节点
     */
    private static ListNode findFromEnd(ListNode head, int k) {
        // 初始化两个指针，都指向头节点
        ListNode fast = head;
        ListNode slow = head;

        // fast 先向前移动 k 步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 当 fast 不为 null 时，fast 和 slow 同时向前移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 返回 slow，即倒数第 k 个节点
        return slow;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        int k1 = 2;
        System.out.println("原链表: " + head1);
        ListNode result1 = removeNthFromEnd(head1, k1);
        System.out.println("删除倒数第 " + k1 + " 个节点后: " + result1);

        ListNode head2 = new ListNode(new int[]{1});
        int k2 = 1;
        System.out.println("原链表: " + head2);
        ListNode result2 = removeNthFromEnd(head2, k2);
        System.out.println("删除倒数第 " + k2 + " 个节点后: " + result2);

        ListNode head3 = new ListNode(new int[]{1, 2});
        int k3 = 1;
        System.out.println("原链表: " + head3);
        ListNode result3 = removeNthFromEnd(head3, k3);
        System.out.println("删除倒数第 " + k3 + " 个节点后: " + result3);

        // 边界情况: n 等于链表长度
        ListNode head4 = new ListNode(new int[]{1, 2, 3});
        int k4 = 3;
        System.out.println("原链表: " + head4);
        ListNode result4 = removeNthFromEnd(head4, k4);
        System.out.println("删除倒数第 " + k4 + " 个节点后: " + result4);
    }
}
