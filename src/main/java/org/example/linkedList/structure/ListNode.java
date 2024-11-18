package org.example.linkedList.structure;

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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + " -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
