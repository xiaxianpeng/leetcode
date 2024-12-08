package org.example.linkedlist;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.linkedlist.structure.ListNode;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 */
public class MergeKSortedLists {

    /**
     * 使用优先队列（最小堆）合并K个升序链表。
     * 算法思路：
     * 1. 初始化一个优先队列，根据节点值进行排序。
     * 2. 将所有链表的头节点加入优先队列。
     * 3. 依次从优先队列中取出最小的节点，连接到结果链表中。
     * 4. 如果取出的节点有下一个节点，将其下一个节点加入优先队列。
     * 5. 重复步骤3和4，直到优先队列为空。
     *
     * @param lists 一个包含K个已排序链表的数组
     * @return 合并后的升序链表的头节点
     */
    public static ListNode mergeKList(List<ListNode> lists) {
        // 当链表列表为空时，直接返回 null
        if (lists.size() == 0) {
            return null;
        }
        // 创建一个最小堆，按节点值从小到大排序
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        // 将每个链表的头节点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }


        // 创建一个虚拟头节点作为合并后链表的头节点
        ListNode dummy = new ListNode(-1);
        // p 指针用于构建最终合并的链表
        ListNode current = dummy;
        // 当最小堆不为空时，重复以下操作
        while (!minHeap.isEmpty()) {
            // 取出当前最小的节点
            ListNode node = minHeap.poll();

            // 将最小节点连接到结果链表
            current.next = node;
            current = current.next;

            // 如果最小节点有下一个节点,加入最小堆（如果存在）
            if (node.next != null) {
                minHeap.add(node.next);
            }

        }

        // 返回合并后的链表，跳过虚拟头节点
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(new int[]{1, 4, 5});
        ListNode L2 = new ListNode(new int[]{1, 3, 4});
        ListNode L3 = new ListNode(new int[]{2, 6});

        List<ListNode> list = Stream.of(L1, L2, L3).collect(Collectors.toList());
        ListNode listNode = mergeKList(list);
        System.out.println(listNode);
    }
}
