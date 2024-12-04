package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class HasCycle {

    /**
     * 判断链表是否有环
     * 使用快慢指针方法来判断链表是否有环。慢指针每次移动一步，快指针每次移动两步，
     * 如果链表中存在环，快慢指针最终会相遇；如果链表中没有环，快指针会到达 null。
     *
     * @param head 链表的头节点
     * @return 如果链表有环返回 true，否则返回 false
     */
    public static boolean hasCycle(ListNode head) {
        // 如果链表为空或只有一个节点，没有环
        if (head == null || head.next == null) {
            return false;
        }

        // 初始化慢指针和快指针,指向 head
        ListNode slow = head;
        ListNode fast = head;

        // 当快指针和快指针的下一个节点都不为 null 时
        while (fast != null && fast.next != null) {
            // 慢指针每次走一步，快指针每次走两步
            slow = slow.next;
            fast = fast.next.next;
            // 如果快慢指针相遇，说明有环
            if (fast == slow) {
                return true;
            }
        }

        // 快指针到达链表末尾，说明链表没有环
        return false;
    }

    public static void main(String[] args) {
        // 测试用例 1: 链表有环
        ListNode head1 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // 创建环，尾部指向第二个节点

        System.out.println("Test Case 1: " + hasCycle(head1));  // 输出: true

        // 测试用例 2: 链表有环
        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        head2.next = node4;
        node4.next = head2; // 创建环，尾部指向头节点

        System.out.println("Test Case 2: " + hasCycle(head2));  // 输出: true

        // 测试用例 3: 链表无环
        ListNode head3 = new ListNode(1);
        System.out.println("Test Case 3: " + hasCycle(head3));  // 输出: false
    }
}
