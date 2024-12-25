package org.example.linkedlist;

import java.util.Stack;

import org.example.linkedlist.structure.ListNode;

/**
 * LCR 025. 两数相加 II
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。
 * 数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 */
public class AddTwoNumbers2 {

    /**
     * 两数之和
     *
     * @param l1 数1
     * @param l2 数2
     * @return 和
     * 算法思想：
     * 1. 将两个链表的值(从头到尾)分别压入两个栈 stack1、stack2 中，这样弹出时就是从“低位”到“高位”进行运算。
     * 2. 在循环中，每次从两个栈的栈顶弹出一个值，进行相加，并加上进位 carry。
     * 3. 将结果 (sum % 10) 压入一个新栈 stack3 中，并更新 carry = sum / 10。
     * 4. 当所有数字弹完后，如果还有剩余的进位 (carry != 0)，也要压入 stack3。
     * 5. 最后，从 stack3 弹出构建新的链表结果，即可得到从最高位到最低位的和。
     * 时间复杂度：O(m + n)，其中 m 和 n 分别是两个链表的长度。
     * 空间复杂度：O(m + n)，因为使用了 3 个栈，但整体级别仍是 O(m + n)。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();


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
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int sum = carry;
            if (s1.isEmpty()) {
                sum += s1.pop();
            }
            if (s2.isEmpty()) {
                sum += s2.pop();
            }

            // 进位
            carry = sum / 10;
            // 余数
            int val = sum % 10;
            s3.push(val);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!s3.isEmpty()) {
            current.next = new ListNode(s3.pop());
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        ListNode ans = addTwoNumbers(l1, l2);
        System.out.println(ans);
    }
}
