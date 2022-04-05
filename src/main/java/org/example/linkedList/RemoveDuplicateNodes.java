package org.example.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xianpeng.xia
 * on 2022/4/5 8:12 PM
 *
 * 删除未排序链表重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/solution/mian-shi-ti-0201-yi-chu-zhong-fu-jie-dia-u619/
 */
public class RemoveDuplicateNodes {

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }

        // 存储已经存在的节点
        Set<Integer> occurred = new HashSet<>();
        ListNode pre = null, cur = head;
        while (cur != null) {
            // 当前待删除节点
            if (occurred.contains(cur.val)) {
                // 删除
                pre.next = cur.next;
            } else {
                occurred.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(head);
        ListNode ans = removeDuplicateNodes(head);
        System.out.println(ans);
    }
}
