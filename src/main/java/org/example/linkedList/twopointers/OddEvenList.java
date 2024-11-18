package org.example.linkedList.twopointers;

import org.example.linkedList.structure.ListNode;

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
 * Created on 2024/11/18 15:04
 */
public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        // 链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return null;
        }
        // 初始化奇数链表和偶数链表的头节点
        // 奇数链表
        ListNode odd = head;
        // 偶数链表
        ListNode even = head.next;
        // 保存偶数链表的头节点
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            // 奇数节点链接下一个奇数节点
            odd.next = even.next;
            // 奇数指针向前移动
            odd = odd.next;

            // 偶数节点链接下一个偶数节点
            even.next = odd.next;
            // 偶数指针向前移动
            even = even.next;

            System.out.println("Current odd pointer: " + odd.val);
            System.out.println("Current even pointer: " + (even != null ? even.val : "null"));
        }
        // 将奇数链表尾部与偶数链表头部链接
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        // 测试用例 1
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(" Original list: " + head1);
        System.out.println("Reordered list: " + oddEvenList(head1));

        System.out.println();

        // 测试用例 2
        ListNode head2 = new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        System.out.println(" Original list: " + head2);
        System.out.println("Reordered list: " + oddEvenList(head2));
    }
}
