package org.example.linkedList;

import java.util.Stack;

import org.example.linkedList.structure.ListNode;

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

    /**
     * 正序链表相加
     *
     * @param l1 l1
     * @param l2 l2
     * @return ans
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        ListNode temp = new ListNode(0);
        ListNode ans = temp;

        // s1存放l1的所有
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        // s2存放l2的所有值
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        // 进位
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (s1.isEmpty()) {
                s1.push(0);
            }
            if (s2.isEmpty()) {
                s2.push(0);
            }
            // sum
            int sum = s1.pop() + s2.pop() + carry;
            // 进位
            carry = sum / 10;
            // 余数
            int val = sum % 10;
            s3.push(val);
        }
        // 处理进位
        if (carry > 0) {
            s3.push(carry);
        }

        while (!s3.isEmpty()) {
            temp.next = new ListNode(s3.pop());
            temp = temp.next;
        }
        return ans.next;
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
