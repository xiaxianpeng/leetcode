package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.tree.construct.ConstructBinaryTree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 11:09 PM
 *
 * 完全⼆叉树的节点个数
 */
public class CountNodes {

    /**
     * @param root 完全⼆叉树
     * @return 完全⼆叉树的节点个数
     *
     * 完全⼆叉树的节点个数
     */
    public static int countNodes(TreeNode root) {
        TreeNode l = root, r = root;

        // 记录左右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }

        // 如果左右子树的高度相同，则是一颗满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右子树不想等，则按照普通方式计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(count(root.left), count(root.right)) + 1;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode root = constructBinaryTree.constructMaximumBinaryTree(new int[]{1, 2, 3, 4, 5});
        int count = count(root);
        System.out.println(count);
    }
}
