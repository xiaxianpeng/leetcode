package org.example.dfs.tree;

import org.example.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4
 */
public class IsValidBST {

    /**
     * 验证二叉搜索树的核心方法。
     * 通过递归比较节点值与其允许的最小和最大值来验证。
     *
     * @param root 二叉树的根节点
     * @return 如果是有效的二叉搜索树则返回 true，否则返回 false
     */
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    /**
     * 递归验证每个节点是否合法。
     *
     * @param node 当前节点
     * @param min  允许的最小值
     * @param max  允许的最大值
     * @return 当前子树是否是有效的二叉搜索树
     */
    private static boolean validate(TreeNode node, Integer min, Integer max) {
        // base case
        if (node == null) {
            return false;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        // 限定左⼦树的最⼤值是 root.val，右⼦树的最⼩值是 root.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }


    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Example 1: " + isValidBST(root1)); // 输出: true

        // 示例 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Example 2: " + isValidBST(root2)); // 输出: false
    }
}
