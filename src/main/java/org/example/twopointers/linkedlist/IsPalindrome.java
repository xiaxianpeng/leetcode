package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */
public class IsPalindrome {

    /**
     * 判断链表是否为回文链表
     * 核心思路：通过快慢指针找到链表的中点，然后将后半部分链表反转，
     * 最后比较前半部分和反转后的后半部分是否相同。
     * 对于奇数节点，跳过中间的节点进行比较；对于偶数节点，完全比较前后两部分。
     *
     * @param head 链表的头节点
     * @return 如果是回文链表，返回true；否则返回false
     */
    public static boolean isPalindrome(ListNode head) {
        // 空链表或只有一个元素是回文链表
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 步骤1：快慢指针找到链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("中点：slow指向的节点值是 " + slow.val);
        // 步骤2：反转链表的后半部分
        ListNode secondHalf = reverse(slow);
        System.out.println("反转后的后半部分链表:" + secondHalf);
        // 步骤3：比较前半部分和反转后的后半部分是否相同
        ListNode firstHalf = head;
        System.out.println("反转后的前半部分链表:" + firstHalf);
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; // 如果有不相等的值，返回false
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head 链表的头节点
     * @return 反转后的链表头节点
     */
    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 2, 1});
        ListNode head1 = new ListNode(new int[]{1, 2, 3, 2, 1});
        boolean isPalindrome = isPalindrome(head);
        boolean isPalindrome1 = isPalindrome(head1);
        System.out.println(isPalindrome);
        System.out.println(isPalindrome1);
    }
}
