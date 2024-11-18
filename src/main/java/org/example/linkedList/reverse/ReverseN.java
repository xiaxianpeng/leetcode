package org.example.linkedList.reverse;

import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/22 12:19 AM
 * 反转链表前 N 个节点
 * https://labuladong.github.io/algo/2/17/17/#二反转链表前-n-个节点
 */
public class ReverseN {

    public ListNode reverseFirstN(ListNode head, int n) {
        // 处理边界情况：如果链表为空或只有一个节点，或者不需要反转，则直接返回原头节点
        if (head == null || n == 1) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        for (int i = 0; i < n; i++) {
            // 如果当前节点为 null，说明 n 大于链表的长度，终止循环
            if (cur == null) {
                break;
            }
            // 保存当前节点的下一个节点
            next = cur.next;
            // 反转当前节点的 next 指针
            cur.next = prev;
            // 移动 prev 和 current 指针向前，为下一次迭代做准备
            prev = cur;
            cur = next;
        }
        // 连接反转后的链表部分与剩余未反转的链表部分
        // head 是反转部分的原始头节点，现在成为尾节点，它的 next 指向 current
        // eg:
        // 假设链表是 1 -> 2 -> 3 -> 4 -> 5，我们需要反转前 3 个节点。
        // 反转操作完成后，我们得到 3 -> 2 -> 1 和 4 -> 5 两个部分，此时 head 是节点 1（反转部分的尾节点），cur 是节点 4（未反转部分的头节点）。
        // head.next = cur; 使链表变成 3 -> 2 -> 1 -> 4 -> 5，实现了完整的链表连接。
        head.next = cur;
        return prev;
    }


    /**
     * 后驱节点
     */
    ListNode successor = null;

    /**
     * @param node head
     * @return // 将链表的前 n 个节点反转（n <= 链表长度），返回新的头节点
     */
    public ListNode reverseN(ListNode node, int n) {
        // 递归终止条件：如果 n 为 1，表示要反转的节点只有一个，或者已经到达要反转的最后一个节点
        if (n == 1) {
            // 记录第 n+1 个节点，此节点会成为反转部分的尾节点的下一个节点
            successor = node.next;
            return node;
        }
        // 递归反转 head.next 为头的链表的前 n - 1 个节点
        ListNode last = reverseN(node.next, n - 1);
        // 反转当前节点 head 与下一个节点的指向关系
        node.next.next = node;
        // 让反转之后的 head 节点和后面的节点（即第 n+1 个节点）连起来
        node.next = successor;
        // 返回反转后的头节点
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new ReverseN().reverseN(head, 2));

        head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new ReverseN().reverseFirstN(head, 2));
    }
}
