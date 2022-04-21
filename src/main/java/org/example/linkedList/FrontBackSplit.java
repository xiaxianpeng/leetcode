package org.example.linkedList;

/**
 * @author xianpeng.xia
 * on 2022/4/21 12:29 PM
 *
 * 实现一个FrontBackSplit()函数，
 * 函数接受一个链表，并将其分成两个子链表——前半部分一个，后半部分一个。
 * 如果元素个数为奇数，则额外的那个元素就放在前面的子链表中。
 * 比如，链表2 -> 3 -> 5 -> 7 -> 11 -> null在经过FrontBackSplit()处理后，
 * 会产生两个链表2 -> 3 -> 5 -> null和7 -> 11 -> null。
 *
 * var source = 1 -> 3 -> 7 -> 8 -> 11 -> 12 -> 14 -> null
 * var front = new Node()
 * var back = new Node()
 * frontBackSplit(source, front, back)
 * front === 1 -> 3 -> 7 -> 8 -> null
 * back === 11 -> 12 -> 14 -> null
 * 注意
 * 如果FrontBackSplit()的任一参数为空，或者 source 参数的链表长度小于2，则应该抛出一个错误。
 */
public class FrontBackSplit {

    public static void frontBackSplit(ListNode source, ListNode front, ListNode back) {
        int length = findLength(source);
        if (length < 2) {
            throw new RuntimeException("length < 2");
        }

        ListNode cur = source;
        // 分割点
        int p = (length - 1) / 2;
        for (int i = 0; i < p; i++) {
            cur = cur.next;
        }

        front = source;
        back = cur.next;
        cur.next = null;

        System.out.println(front);
        System.out.println(back);
    }

    private static int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode source = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode front = new ListNode(-1);
        ListNode back = new ListNode(-1);
        frontBackSplit(source, front, back);


    }
}
