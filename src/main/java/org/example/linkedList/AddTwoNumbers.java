package org.example.linkedList;

/**
 * @date 2020/09/30
 * @time 16:38
 * 链表两数相加
 */
public class AddTwoNumbers {

    public static ListNode solution(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummyHead = new ListNode(0);
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 指针p负责构建新链表
        ListNode p = dummyHead;
        // 进位
        int carry = 0;
        // 执行加法，两条链表走完且没有进位才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 进位
            carry = val / 10;
            // 余数
            int remainder = val % 10;
            // 构建新节点
            p.next = new ListNode(remainder);
            p = p.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        // 342 + 465 = 807
        System.out.println(l1);
        System.out.println(l2);
        ListNode sum = solution(l1, l2);
        System.out.println(sum);

    }
}
