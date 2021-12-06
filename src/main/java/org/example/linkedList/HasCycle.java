package org.example.linkedList;

/**
 * @author xianpeng.xia
 * on 2021/12/7 1:11 上午
 * 判断链表是否包含环
 * https://labuladong.gitee.io/algo/2/17/16/#判断链表是否包含环
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    static boolean hasCycle(ListNode head) {
        //快慢指针都指向head
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        head.next = head;

        boolean hasCycle = hasCycle(head);
        System.out.println(hasCycle);
    }
}
