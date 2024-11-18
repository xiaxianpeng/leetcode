package org.example.twopointers.linkedlist;

import org.example.linkedList.structure.ListNode;

/**
 * 2130. 链表最大孪生和
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，
 * 第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。
 * 这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 * 示例 1：
 * 输入：head = [5,4,2,1]
 * 输出：6
 * 解释：
 * 节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
 * 链表中没有其他孪生节点。
 * 所以，链表的最大孪生和是 6 。
 * 示例 2：
 * 输入：head = [4,2,2,3]
 * 输出：7
 * 解释：
 * 链表中的孪生节点为：
 * - 节点 0 是节点 3 的孪生节点，孪生和为 4 + 3 = 7 。
 * - 节点 1 是节点 2 的孪生节点，孪生和为 2 + 2 = 4 。
 * 所以，最大孪生和为 max(7, 4) = 7 。
 * 示例 3：
 * 输入：head = [1,100000]
 * 输出：100001
 * 解释：
 * 链表中只有一对孪生节点，孪生和为 1 + 100000 = 100001 。
 * https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/18 16:23
 */
public class PairSum {

    public static int pairSum(ListNode head) {
        // 快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针每次走一步
            slow = slow.next;
            // 快指针每次走两步
            fast = fast.next.next;
        }
        System.out.println("链表中点位置：" + slow.val);

        // 反转链表后半部分
        ListNode secondHalf = reverse(slow);

        // 遍历前后两部分，计算最大孪生和
        int maxSum = 0;
        ListNode firstHalf = head;
        while (secondHalf != null) {
            int twinSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, twinSum);
            System.out.println("当前节点值：" + firstHalf.val + " 和 " + secondHalf.val + " -> 当前孪生和：" + twinSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 临时保存下一个节点
            ListNode next = curr.next;
            // 反转指针
            curr.next = prev;
            // 将 prev 和 curr 向前移动一位，准备下一次迭代
            prev = curr;
            // 当前节点移动到下一个节点，继续迭代
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // 测试用例 1
        ListNode head1 = new ListNode(new int[]{5, 4, 2, 1});
        System.out.println("链表最大孪生和：" + pairSum(head1));

        System.out.println();

        // 测试用例 2
        ListNode head2 = new ListNode(new int[]{4, 2, 2, 3});
        System.out.println("链表最大孪生和：" + pairSum(head2));

        System.out.println();

        // 测试用例 3
        ListNode head3 = new ListNode(new int[]{1, 100000});
        System.out.println("链表最大孪生和：" + pairSum(head3));
    }
}
