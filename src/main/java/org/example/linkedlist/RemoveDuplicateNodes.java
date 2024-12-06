package org.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.example.linkedlist.structure.ListNode;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 示例1：
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2：
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 */
public class RemoveDuplicateNodes {

    /**
     * 删除无序链表中的重复节点，保留首次出现的节点。
     * 使用一个 HashSet 来记录已访问的节点值，避免重复。
     *
     * @param head 链表头节点
     * @return 返回去重后的链表头节点
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> visited = new HashSet<>();
        ListNode curr = head;
        visited.add(curr.val);// 将头节点的值加入集合

        // 遍历链表
        while (curr != null && curr.next != null) {
            if (visited.contains(curr.next.val)) {
                // 如果当前节点的下一个节点值已经出现过，跳过它
                curr.next = curr.next.next;
            } else {
                // 否则，将当前节点的下一个节点值加入集合，并继续移动
                visited.add(curr.next.val);
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(head);
        ListNode ans = removeDuplicateNodes(head);
        System.out.println(ans);

        ListNode head2 = new ListNode(new int[]{1, 1, 1, 1, 2});
        System.out.println(head2);
        ListNode ans2 = removeDuplicateNodes(head2);
        System.out.println(ans2);
    }
}
