package org.example.linkedlist.structure;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xianpeng.xia
 * on 2021/1/22 8:59 下午
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be null");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;

        }
    }

    /**
     * 重写 toString 方法，以安全的方式打印链表。
     * 如果链表存在环形结构，则在检测到环后停止遍历，并在字符串中标记环的存在。
     *
     * @return 链表的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        Set<ListNode> visited = new HashSet<>(); // 用于检测环形链表

        while (current != null) {
            // 检查当前节点是否已经访问过，防止无限循环
            if (visited.contains(current)) {
                sb.append("... (cycle detected)");
                break;
            }
            visited.add(current);

            sb.append(current.val);
            sb.append(" -> ");
            current = current.next;
        }

        sb.append("NULL");
        return sb.toString();
    }
}
