package org.example.linkedList;

import org.example.linkedList.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/11 12:00 AM
 *
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class SortList {

    /**
     * @param head head
     * @return 归并排序（递归法）
     * 通过递归实现链表归并排序，有以下两个环节：
     *
     * 1、分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * ** 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * ** 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * ** 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * ** cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     * 2、合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * ** 双指针法合并，建立辅助ListNode h 作为头部。
     * ** 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * ** 返回辅助ListNode h 作为头部的下个节点 h.next。
     * ** 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     * 当题目输入的 head == None 时，直接返回None。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 中点
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left != null ? left : right;
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        System.out.println(head);
        ListNode sortList = sortList(head);
        System.out.println(sortList);
    }
}
