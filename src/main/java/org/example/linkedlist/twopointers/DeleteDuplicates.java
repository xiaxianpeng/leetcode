package org.example.linkedlist.twopointers;


import org.example.linkedlist.structure.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class DeleteDuplicates {

    /**
     * 去除已排序链表中的重复元素。
     *
     * @param head 链表头节点
     * @return 返回去重后的链表头节点
     * 算法思路：
     * 由于链表是已排序的，重复的元素必然是相邻的。因此只需遍历链表，删除相邻的重复节点。
     * 通过逐个比较当前节点与下一个节点的值，如果相同则跳过下一个节点，否则继续遍历。
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // 处理空链表的情况
        if (head == null) {
            return null;
        }
        ListNode slow = head;// slow指针，指向去重后的链表
        ListNode fast = head;// fast指针，遍历原链表

        // 遍历链表
        while (fast != null) {
            if (fast.val != slow.val) {
                // 当前节点与上一个节点不相同，将 slow 的 next 指向 fast
                slow.next = fast;
                // 移动 slow 指针
                slow = slow.next;
            }
            // 移动 fast 指针
            fast = fast.next;
        }

        // 断开与后续重复节点的连接，确保链表结束
        slow.next = null;
        return head;// 返回去重后的链表头
    }

    /**
     * 通过遍历链表，比较当前节点和下一个节点的值，若相等则跳过下一个节点
     * 否则正常前进，从而达到去重的效果
     *
     * @param head 排序链表的头节点
     * @return 去重后的链表头节点
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        // 定义curr指针用来遍历链表
        ListNode curr = head;
        // 当curr不为空且curr.next不为空时，才进行比较
        while (curr != null && curr.next != null) {
            // 如果当前节点和下一个节点值相等，说明有重复
            if (curr.val == curr.next.val) {
                // 将当前节点的next指向下一个节点的next，实现跳过节点
                curr.next = curr.next.next;
            } else {
                // 如果不相等，正常向后移动
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // 输入 [1, 1, 2]，输出 [1, 2]
        ListNode head1 = new ListNode(new int[]{1, 1, 2});
        System.out.println("Before removing duplicates: " + head1);
        head1 = deleteDuplicates2(head1);
        System.out.println("After removing duplicates: " + head1);

        // 输入 [1, 1, 2, 3, 3]，输出 [1, 2, 3]
        ListNode head2 = new ListNode(new int[]{1, 1, 2, 3, 3});
        System.out.println("Before removing duplicates: " + head2);
        head2 = deleteDuplicates2(head2);
        System.out.println("After removing duplicates: " + head2);
    }
}
