package org.example.linkedList;

/**
 * @author xianpeng.xia
 * on 2022/4/8 12:57 PM
 *
 * 剑指 Offer II 028. 展平多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 *
 * 如何表示测试用例中的多级链表？
 *
 * 以 示例 1 为例：
 *
 * 1---2---3---4---5---6--NULL
 * *       |
 * *       7---8---9---10--NULL
 * *           |
 * *           11--12--NULL
 * 序列化其中的每一级之后：
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Qv1Da2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Flatten {

    public static Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private static Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            // 如果有子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);
                // 将node与child相连
                cur.next = cur.child;
                cur.child.prev = cur;
                // 如果next不为空，就将last与next相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                //child置空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    public static class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
