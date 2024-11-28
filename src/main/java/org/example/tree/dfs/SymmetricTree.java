package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class SymmetricTree {

    /**
     * 检查二叉树是否为对称的。
     * 核心思路是通过递归比较左右子树，检查每个对应节点及其子树是否一致。
     *
     * @param root 二叉树的根节点
     * @return 二叉树是否对称
     */
    public static boolean isSymmetric(TreeNode root) {
        // 如果根节点为空，则树是对称的
        if (root == null) {
            return true;// 空树是对称的
        }
        // 从根节点的左右子节点开始检查对称性
        return isMirror(root.left, root.right);
    }

    /**
     * 辅助方法，递归检查两棵子树是否互为镜像。
     *
     * @param left  左子树的节点
     * @param right 右子树的节点
     * @return 子树是否互为镜像
     */
    public static boolean isMirror(TreeNode left, TreeNode right) {
        // 如果两个子树均为空，则它们是对称的
        if (left == null && right == null) {
            return true;// 两个空节点互为镜像
        }

        // 如果其中一个为空，且另一个不为空，则它们不是对称的
        if (left == null || right == null) {
            return false;// 一个为空，另一个不为空，则不是镜像
        }

        System.out.println("Comparing nodes: " + left.val + " and " + right.val);

        // 当前节点值相等且左右子树对称，则树对称
        return left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        TreeUtil.printTree(root1);
        System.out.println("Is tree symmetric? " + isSymmetric(root1)); // 输出: true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        TreeUtil.printTree(root2);
        System.out.println("Is tree symmetric? " + isSymmetric(root2)); // 输出: false
    }
}
