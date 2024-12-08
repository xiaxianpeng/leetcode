package org.example.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 实现一个FrontBackSplit()函数，
 * 函数接受一个链表，并将其分成两个子链表——前半部分一个，后半部分一个。
 * 如果元素个数为奇数，则额外的那个元素就放在前面的子链表中。
 * 比如，链表2 -> 3 -> 5 -> 7 -> 11 -> null在经过FrontBackSplit()处理后，
 * 会产生两个链表2 -> 3 -> 5 -> null和7 -> 11 -> null。
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

    /**
     * 分割链表为前半部分和后半部分。
     *
     * @param source 要分割的源链表
     * @return 一个 SplitResult 对象，包含前半部分和后半部分的链表
     * @throws IllegalArgumentException 如果 source 为 null 或链表长度小于 2
     */
    public static SplitResult frontBackSplit(ListNode source) {
        if (source == null) {
            throw new IllegalArgumentException("source is null");
        }
        int length = findLength(source);
        if (length < 2) {
            throw new RuntimeException("length < 2");
        }

        // 分割点
        int p = (length - 1) / 2;
        ListNode cur = source;
        for (int i = 0; i < p; i++) {
            cur = cur.next;
        }

        ListNode front = source;
        ListNode back = cur.next;
        cur.next = null;

        return new SplitResult(front, back);
    }

    /**
     * 计算链表的长度。
     *
     * @param head 链表的头节点
     * @return 链表的长度
     */
    private static int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 用于存储分割结果的辅助类。
     */
    public static class SplitResult {
        public ListNode front;
        public ListNode back;

        public SplitResult(ListNode front, ListNode back) {
            this.front = front;
            this.back = back;
        }
    }

    public static void main(String[] args) {
        ListNode source1 = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
        SplitResult result1 = frontBackSplit(source1);
        System.out.println("Source List" + source1);
        System.out.println("Front List: " + result1.front);
        System.out.println("Back List: " + result1.back);

        ListNode source2 = new ListNode(new int[]{1, 3, 7, 8, 11, 12, 14});
        SplitResult result2 = frontBackSplit(source2);
        System.out.println("Source List 2" + source2);
        System.out.println("Front List 2: " + result2.front);
        System.out.println("Back List 2: " + result2.back);
    }
}
