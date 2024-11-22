package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class DetectCycle {

    /**
     * 使用快慢指针法检测链表中的环并返回环的起始节点。
     *
     * @param head 链表的头节点
     * @return 环的起始节点或 null
     */
    public static ListNode detectCycle(ListNode head) {
        // 初始化快慢指针都指向头节点
        ListNode slow = head;
        ListNode fast = head;
        // 快指针一次走两步，慢指针一次走一步，如果有环它们最终会相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 检测到环，跳出循环
            if (slow == fast) {
                break;
            }
        }
        // 如果快指针遇到空指针说明没有环，返回 null
        if (fast == null || fast.next == null) {
            return null;
        }
        // 将慢指针重新指向头节点，快指针保持在相遇点
        slow = head;
        // 两个指针同时前进，当它们再次相遇时，相遇的节点就是环的起始节点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        // 返回环的起始节点
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        // 创建环：链表中的第二个节点（值为2）是环的起始位置
        head.next.next.next.next = head.next;

        ListNode detectCycle = detectCycle(head);
        System.out.println("环的起始节点的值为: " + detectCycle.val);

    }
}
