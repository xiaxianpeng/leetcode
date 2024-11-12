package org.example.linkedList.reverse;

import org.example.linkedList.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/22 12:03 AM
 * <p>
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 */
public class Reverse {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    /**
     * prev 用来跟踪链表翻转过程中的前驱节点。
     * curr 用来跟踪当前处理的节点。
     * 在循环中，每个节点的 next 指针被更新为指向它的前驱节点，实现翻转。
     * 最终，当 curr 变为 null，表示链表已经遍历完成，此时 prev 指向原链表的最后一个节点，即翻转后的新头节点。
     */
    public static ListNode reverseList(ListNode head) {
        // prev 用于记录当前节点的前一个节点
        ListNode prev = null;
        // curr 用于遍历链表，初始指向头节点
        ListNode curr = head;
        // 遍历链表直到 curr 为 null，表示到达链表尾部
        while (curr != null) {
            // next 临时存储 curr 的下一个节点，因为翻转后 curr 的 next 将改变
            ListNode next = curr.next;
            // 翻转操作：将 curr 的 next 指针指向 prev
            curr.next = prev;
            // 将 prev 和 curr 向前移动一位，准备下一次迭代
            prev = curr;
            // 当前节点移动到下一个节点，继续迭代
            curr = next;
        }
        // 当循环结束时，prev 将指向原链表的最后一个节点，即翻转后的新头节点
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode reverse = reverseList(head);
        System.out.println(reverse);
    }
}
