package org.example.linkedList.twopointers;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/21 10:25 PM
 *
 * 如果链表中含有环，如何计算这个环的起点
 *
 * * 给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * *
 * * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * * 不允许修改 链表。
 * *
 * * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        // 类似 hasCycle 函数

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // fast  遇到空指针说明没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        //  重新指向头节点
        slow = head;
        // 快慢指针同步前进，相交点就是环节点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        // 环
        head.next.next.next.next = head.next;

        ListNode detectCycle = detectCycle(head);
        System.out.println();

    }
}
