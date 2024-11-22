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
     * @param list k个有序链表
     * @return 合并有序链表
     * 这个算法是面试常考题，它的时间复杂度是多少呢？
     * <p>
     * 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；
     * 所有的链表节点都会被加入和弹出 pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。
     */
    public static ListNode mergeKList(List<ListNode> list) {
        // 当链表列表为空时，直接返回 null
        if (list.size() == 0) {
            return null;
        }
        // 创建一个最小堆，用于维护各个链表的当前节点
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        // 将每个链表的头节点加入最小堆
        for (ListNode head : list) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        // 创建一个虚拟头节点作为合并后链表的头节点
        ListNode dummy = new ListNode(-1);
        // p 指针用于构建最终合并的链表
        ListNode p = dummy;
        // 当最小堆不为空时，重复以下操作
        while (!minHeap.isEmpty()) {
            // 弹出最小堆中的最小节点
            ListNode node = minHeap.poll();
            // 将其接到合并链表的末尾
            p.next = node;
            // 将弹出节点的下一个节点加入最小堆（如果存在）
            if (node.next != null) {
                minHeap.add(node.next);
            }
            // 移动 p 指针
            p = p.next;
        }
        // 返回合并后的链表的头节点（虚拟头节点的下一个节点）
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
