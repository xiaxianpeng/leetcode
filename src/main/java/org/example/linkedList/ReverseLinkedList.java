package org.example.linkedList;


/**
 * @author xianpeng.xia
 * on 2021/1/22 10:57 下午
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        ListNode reverseList = reverseList(listNode);
        System.out.println(reverseList);
    }
}
