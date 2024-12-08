package org.example.twopointers.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * 面试题 02.04. 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class Partition {

    /**
     * 分割链表，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     * 算法思路：
     * 1. 创建两个虚拟头节点，分别用于存储小于 x 和大于或等于 x 的节点。
     * 2. 遍历原链表，将节点分配到对应的链表中。
     * 3. 连接两个链表，并将最终链表的尾节点指向 null，避免环形链表。
     * 4. 返回分割后的新链表的头节点。
     * 时间复杂度：O(n)，其中 n 是链表的长度。
     * 空间复杂度：O(1)，只使用了常数级别的额外空间。
     *
     * @param head 链表的头节点
     * @param x    分割的基准值
     * @return 分割后的链表头节点
     */
    public static ListNode partition(ListNode head, int x) {

        // 创建两个虚拟头节点，分别用于存储小于 x 和大于等于 x 的节点
        ListNode smallDummy = new ListNode(-1);
        ListNode bigDummy = new ListNode(-1);

        // 初始化两个指针，分别指向两个虚拟头节点
        ListNode small = smallDummy;
        ListNode big = bigDummy;

        // 遍历原链表，将节点分配到对应的链表中
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                small.next = current;// 将节点添加到 small 链表
                small = small.next;// 移动 small 指针
            } else {
                big.next = current;// 将节点添加到 big 链表
                big = big.next;// 移动 big 指针
            }
            current = current.next;// 移动到下一个节点
        }

        // 连接 small 链表和 big 链表
        small.next = bigDummy.next;
        // 断开 big 链表的尾节点指向 null，避免形成环
        big.next = null;

        // 返回分割后的链表头节点
        return smallDummy.next;
    }

    public static void main(String[] args) {
        //  [1,4,3,2,5,2], x = 3
        int[] arr1 = {1, 4, 3, 2, 5, 2};
        ListNode head1 = new ListNode(arr1);
        System.out.println("原链表: " + head1);
        ListNode partitioned1 = partition(head1, 3);
        System.out.println("分割后链表: " + partitioned1);
        System.out.println("-----------------------------------");

        // [2,1], x = 2
        int[] arr2 = {2, 1};
        ListNode head2 = new ListNode(arr2);
        System.out.println("原链表: " + head2);
        ListNode partitioned2 = partition(head2, 2);
        System.out.println("分割后链表: " + partitioned2);
        System.out.println("-----------------------------------");
    }
}
