package org.example.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * Created on 2024/11/22 17:19
 */
public class SwapPairs {

    /**
     * 方法：交换链表中的相邻节点
     * 时间复杂度：O(n)，其中 n 是链表的长度，遍历每个节点一次。
     * 空间复杂度：O(1)，只使用了常数的额外空间。
     *
     * @param head 链表的头节点
     * @return 交换后的链表头节点
     * *解题思路：
     * *使用一个虚拟头节点 dummy 作为链表的新头节点，方便处理边界条件。
     * *使用一个指针 curr 遍历链表，每次交换两个相邻节点的指针指向。
     * *具体步骤：curr 节点指向的第一个节点与第二个节点交换位置，curr 然后跳过两个节点，继续进行下一个交换。
     * *直到链表末尾。
     */
    public static ListNode swapPairs(ListNode head) {
        // 创建一个虚拟头节点，简化处理边界情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // curr 是当前处理的节点，初始化为虚拟头节点
        ListNode curr = dummy;

        // 遍历链表，直到链表末尾
        while (curr.next != null && curr.next.next != null) {
            // 找到待交换的两个节点
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            System.out.println("Swapping: " + first.val + " and " + second.val);

            // 执行交换操作
            first.next = second.next;
            second.next = first;

            //在交换两个节点之后，second 成为这两个节点的新的头节点，first 变成了新的尾节点。
            // 更新 curr 的 next 指向交换后的第二个节点（即新的头节点）
            curr.next = second;
            System.out.println("List: " + dummy.next);

            // 移动 curr 指针，跳过已交换的两个节点，继续处理后续节点
            curr = first;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        //  输入: [1,2,3,4], 输出: [2,1,4,3]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println("Initial list: " + head1);
        ListNode result1 = swapPairs(head1);
        System.out.println("After swapping pairs: " + result1);

        //  输入: [], 输出: []
        ListNode head2 = null;
        System.out.println("Initial list: " + head2);
        ListNode result2 = swapPairs(head2);
        System.out.println("After swapping pairs: " + result2);

        //  输入: [1], 输出: [1]
        ListNode head3 = new ListNode(1);
        System.out.println("Initial list: " + head3);
        ListNode result3 = swapPairs(head3);
        System.out.println("After swapping pairs: " + result3);
    }
}
