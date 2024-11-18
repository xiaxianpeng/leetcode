package org.example.linkedList;


import org.example.linkedList.structure.ListNode;

/**
 * @Author xiapeng
 * @Date: 2022/03/28/3:48 下午
 * @Description: 删除排序链表中的重复元素
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast]
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++;
            fast = fast.next;
        }
        // 断开与后面重复的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 2, 3, 3, 3, 4});
        ListNode listNode = deleteDuplicates(head);
        System.out.println(listNode);
    }
}
