package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 10:56 PM
 * 给你⼆叉树的根结点 root，请你将它展开为⼀个单链表：
 * 1、展开后的单链表应该同样使⽤ TreeNode，其中 right ⼦指针指向链表中下⼀个结点，⽽左⼦指针始终 为 null。
 * 2、展开后的单链表应该与⼆叉树 先序遍历 顺序相同。
 * 输⼊：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class Flatten2ListNode {

    public static void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // 先递归拉平左右子树
        flatten(root.left);
        flatten(root.right);
        // ---先序遍历位置---
        // 1、左右子树已经被拉成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2、将左子树作为右子树
        root.right = left;
        root.left = null;
        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
