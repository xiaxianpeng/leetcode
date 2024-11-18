package org.example.linkedList.reverse;

import org.example.linkedList.structure.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class Reverse {

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

    public static ListNode reverse(ListNode node) {
        // 递归终止条件：如果节点为空或只有一个节点，直接返回当前节点
        if (node == null || node.next == null) {
            return node;
        }
        // 递归反转从当前节点的下一个节点开始的剩余链表，并获取新的头节点
        ListNode rev = reverse(node.next);
        // 设置当前节点的下一个节点的 next 指针指向当前节点
        // 也就是说，把当前节点放在其下一个节点的后面，完成翻转
        node.next.next = node;
        // 将当前节点的 next 指针设置为 null，因为它会成为反转后的链表的最后一个节点
        node.next = null;
        // 在每一层递归中返回新的头节点
        return rev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        ListNode reverse = reverseList(head);
        System.out.println(reverse);
    }
}
