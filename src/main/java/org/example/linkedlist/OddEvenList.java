package org.example.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/6 1:30 PM
 * 奇偶节点链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * *
 * 给定单链表的头节点head，
 * 将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，
 * 然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: head = [1,2,3,4,5]
 * 输出:[1,3,5,2,4]
 * 示例 2:
 *
 *
 *
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇
        ListNode oddHead = head, oddTail = oddHead;
        // 偶
        ListNode evenHead = head.next, evenTail = evenHead;
        // 指针链表
        ListNode p = head.next.next;
        while (p != null) {
            // 因为是第三个节点，直接拼在奇数链表后
            oddTail = oddTail.next = p;
            p = p.next;
            // 当链表还有元素的时候，拼在偶数链表后
            if (p != null) {
                evenTail = evenHead.next = p;
                p = p.next;
            }
        }
        // 将奇数链表后的尾节点拼上偶数链表的头节点，
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(head);
        ListNode oddEvenList = oddEvenList(head);
        System.out.println(oddEvenList);
    }
}
