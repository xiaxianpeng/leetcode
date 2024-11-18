package org.example.stack;

import java.util.Stack;
import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/4 6:02 PM
 * * http://bubuko.com/infodetail-3818449.html
 * 正序链表相加Add Two Numbers
 * 使用栈
 * 例子
 * 7->2->4->3
 * +
 * ****5->6>4
 * =
 * 7->8->0->7
 */
public class AddTwoNumbers {

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
        ListNode l1 = new ListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        ListNode ans = addTwoNumbers(l1, l2);
        System.out.println(ans);
    }
}
