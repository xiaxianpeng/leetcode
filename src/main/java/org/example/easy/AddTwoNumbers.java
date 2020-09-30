package org.example.easy;

import org.example.bean.ListNode;

/**
 * @date 2020/09/30
 * @time 16:38
 */
public class AddTwoNumbers {

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        // 进位
        int carry = 0;
        while (p != null || q != null) {
            int x = p.getVal() == null ? 0 : (int) p.getVal();
            int y = q.getVal() == null ? 0 : (int) q.getVal();
            int sum = x + y + carry;
            // 进位
            carry = sum / 10;
            // 余数
            int remainder = sum % 10;
            curr.setNextNode(new ListNode(remainder));
            curr = curr.getNextNode();
            if (p != null) {
                p = p.getNextNode();
            }
            if (q != null) {
                q = q.getNextNode();
            }
        }
        return dummyHead.getNextNode();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.setNextNode(l2);
        l2.setNextNode(l3);

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.setNextNode(l5);
        l5.setNextNode(l6);

        // 342 + 465 = 807
        System.out.println(l1);
        System.out.println(l4);
        ListNode sum = solution(l1, l4);
        System.out.println(sum);

    }
}
