package org.example.linkedlist.twopointers;

import org.example.linkedlist.structure.ListNode;

/**
 * LCR 136. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * Created on 2024/12/24 15:52
 */
public class DeleteNode {

    /**
     * 删除链表指定节点
     *
     * @param head 链表的头节点
     * @param val  要删除的节点的值
     * @return 删除后的链表头节点
     * 算法思路：
     * 使用虚拟头节点简化删除操作，避免单独处理删除头节点的情况
     * 遍历链表，找到值为val的节点，并修改前一个节点next指针以跳过该节点
     */
    public static ListNode deleteNode(ListNode head, int val) {
        // 创建一个虚拟头节点，指向原链表的头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 初始化当前指针为虚拟头节点
        ListNode current = dummy;

        // 遍历链表
        while (current.next != null) {
            if (current.next.val == val) {
                // 修改指针，删除节点
                current.next = current.next.next;
                break;//如果只删除第一个匹配的节点，可以退出循环
            }
            // 移动到下一个节点
            current = current.next;
        }
        // 返回新的头节点
        return dummy.next;
    }

    /**
     * 算法思路：
     * 不使用虚拟头节点，先处理删除头节点的情况。
     * 然后遍历链表，找到值为 val 的节点，并修改前一个节点的 next 指针以跳过该节点。
     *
     * @param head 链表的头节点
     * @param val  要删除的节点的值
     * @return 删除后的链表头节点
     */
    public static ListNode deleteNode2(ListNode head, int val) {

        // 如果头节点本身需要被删除
        if (head.val == val) {
            return head.next;
        }

        // 初始化前驱节点和当前节点
        ListNode prev = head;
        ListNode curr = head.next;

        // 遍历链表，寻找要删除的节点
        if (curr != null && curr.val != val) {
            prev = prev.next;
            curr = curr.next;
        }

        // 如果找到要删除的节点，修改指针跳过该节点
        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(new int[]{4, 5, 1, 9});
        System.out.println(head1);
        System.out.println(deleteNode(head1, 5));
    }
}
