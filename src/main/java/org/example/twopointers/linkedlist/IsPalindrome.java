package org.example.twopointers.linkedlist;

import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/3/28 6:40 PM
 * 判断是否是回文单链表
 */
public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // 快慢指针找到链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast指针没有指向null，说明链表长度为奇数，slow再往前一步
        if (fast != null) {
            slow = slow.next;
        }
        // 对比回文子串
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
