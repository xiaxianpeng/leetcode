package org.example.linkedList;


import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2021/1/22 9:48 下午
 */
public class RemoveElements {

    public static ListNode removeElement(ListNode head, int val) {
        // 使用虚拟头节点
        ListNode dummyNode = new ListNode(1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        // 如果prev.next == val就删除
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        // ⚠️ 返回的是dummyNode.next
        return dummyNode.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 42, 53, 3, 2, 3, 2, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = removeElements(listNode, 2);
        System.out.println(listNode1);

    }
}
