package org.example.tree;

/**
 * 计算一棵二叉树共有几个节点
 * Created on 2024/11/16 00:25
 */
public class Count {

    /**
     * // 定义：count(node) 返回以 node 为根的树有多少节点
     */
    public static int count(TreeNode node) {
        // base case
        if (node == null) {
            return 0;
        }
        // 自己加上子树的节点数就是整棵树的节点数
        return 1 + count(node.left) + count(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(count(root));
    }
}
