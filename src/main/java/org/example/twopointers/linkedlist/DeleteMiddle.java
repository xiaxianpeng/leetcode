package org.example.twopointers.linkedlist;

import org.example.linkedList.structure.ListNode;

/**
 * 2095. 删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * 示例 1：
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 * 解释：
 * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
 * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
 * 返回结果为移除节点后的新链表。
 * 示例 2：
 * 输入：head = [1,2,3,4]
 * 输出：[1,2,4]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
 * 示例 3：
 * 输入：head = [2,1]
 * 输出：[2]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
 * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
 * https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/18 13:02
 */
public class DeleteMiddle {
    /**
     * 删除链表的中间节点
     * 1. 使用快慢指针来定位中间节点。
     * 2. 当快指针到达链表尾部时，慢指针指向链表的中间节点。
     * 3. 删除中间节点时，调整慢指针前一个节点的 next 指针。
     */
    public static ListNode deleteMiddle(ListNode head) {
        // 特殊情况：链表为空或只有一个节点
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 用于记录慢指针的前一个节点
        ListNode prev = head;
        // 快慢指针移动，快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            // 更新前一个节点为慢指针
            prev = slow;
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
        }
        // 删除中间节点，即将前一个节点的 next 指向慢指针的下一个节点
        prev.next = slow.next;
        // 返回修改后的链表头节点
        return head;
    }

    public static void main(String[] args) {
        // 创建测试链表：1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        // 删除中间节点
        System.out.println(deleteMiddle(head));// 输出结果：1 -> 3 -> 4 -> 1 -> 2 -> 6

        // 创建测试链表：1 -> 2 -> 3 -> 4
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // 删除中间节点
        System.out.println(deleteMiddle(head));// 输出结果：1 -> 2 -> 4
    }
}
