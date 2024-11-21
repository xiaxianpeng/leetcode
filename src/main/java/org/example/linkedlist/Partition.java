package org.example.linkedlist;

import org.example.linkedlist.structure.ListNode;

/**
 * @author xianpeng.xia
 * on 2022/4/5 8:43 PM
 *
 * 分割链表（双指针）
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你不需要保留每个分区中各节点的初始相对位置。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci/solution/mian-shi-ti-0204-fen-ge-lian-biao-shuang-46vz/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Partition {

    /**
     * * 思路
     * * 1、新建两个链表 sml_dummy , big_dummy ，分别用于添加所有「节点值 < x<x 」、「节点值 \geq x≥x 」的节点。
     * * 2、遍历链表 head 并依次比较各节点值 head.val 和 xx 的大小：
     * * 1）若 head.val < x ，则将节点 head 添加至链表 sml_dummy 最后面；
     * * 2）若 head.val >= x ，则将节点 head 添加至链表 big_dummy 最后面；
     * * 3、遍历完成后，拼接 sml_dummy 和 big_dummy 链表。
     * * 4、最终返回头节点 sml_dummy.next 即可
     *
     * @param head 链表
     * @param x 标准
     * @return 分割后的链表
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1), bigDummy = new ListNode(-1);
        ListNode small = smallDummy, big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigDummy.next;
        big.next = null;
        return smallDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        System.out.println(head);
        ListNode partition = partition(head, x);
        System.out.println(partition);
    }
}
