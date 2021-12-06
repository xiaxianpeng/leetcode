package org.example.linkedList;

import java.util.PriorityQueue;

/**
 * @author xianpeng.xia
 * on 2021/12/6 11:42 下午
 * 合并K个升序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

    static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // 将k个链表的头节点插入到最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接入到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 4, 5}), l2 = new ListNode(new int[]{1, 3, 4}), l3 = new ListNode(new int[]{2, 6});
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode ret = mergeKLists(lists);
        System.out.println(ret);
    }
}
