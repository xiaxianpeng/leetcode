package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * 328. 奇偶链表
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 */
public class OddEvenList {

    /**
     * 思路：
     * 1. 定义两个链表，分别存储奇数位置的节点和偶数位置的节点。
     * 2. 遍历链表时，将奇数节点和偶数节点分别加入到两个链表中。
     * 3. 最后，将奇数链表与偶数链表连接起来，返回新的链表头。
     *
     * @param head 链表的头节点
     * @return 返回调整后的链表头节点
     */
    public static ListNode oddEvenList(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // odd 和 even 用来分别存储奇数位置和偶数位置节点
        ListNode odd = head;// 奇数链表的头部
        ListNode even = head.next;// 偶数链表的头部
        // 指针链表
        ListNode oddTail = odd;// 奇数链表的尾部
        ListNode evenTail = even;// 偶数链表的尾部

        // 遍历链表
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = oddTail.next.next;// oddTail 指向下一个奇数节点
            evenTail.next = evenTail.next.next;// evenTail 指向下一个偶数节点

            oddTail = oddTail.next;// oddTail 向后移动
            evenTail = evenTail.next;// evenTail 向后移动
        }

        // 将奇数链表与偶数链表连接起来
        oddTail.next = even;

        return odd;// 返回合并后的链表头
    }

    public static void main(String[] args) {
        // 示例 1
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("Before: " + head1);
        ListNode result1 = oddEvenList(head1);
        System.out.println("After: " + result1);

        // 示例 2
        ListNode head2 = new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        System.out.println("Before: " + head2);
        ListNode result2 = oddEvenList(head2);
        System.out.println("After: " + result2);
    }
}
