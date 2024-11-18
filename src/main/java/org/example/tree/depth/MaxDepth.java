package org.example.tree.depth;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxDepth {

    /**
     * dp算法思路
     * 输⼊⼀个节点，返回以该节点为根的⼆叉树的最⼤深度
     * 让我们分步解释上述 maxDepth() 方法的递归逻辑：
     * 1、基本情况（Base Case）：
     * 当你到达了一个空节点（null），说明你已经越过了叶子节点（因为叶子节点没有子节点）。
     * 在此情况下，该路径的深度为 0，因为我们不计算空（null）节点的深度。
     * 2、递归步骤（Recursive Step）：
     * 如果当前节点不是空节点，我们需要分别计算其左右子树的深度。
     * 为此，我们对左子节点调用 maxDepth() 方法来计算左子树的深度，并对右子节点调用同样的方法计算右子树的深度。
     * 这两个调用本身也是递归的，因为它们会再次检查子节点是否为空，并对其子树进行同样的操作。
     * 当我们得到左子树和右子树的深度后，最大深度将是两者中的较大值（因为我们要找的是最长路径）。
     * 然后，我们在这个最大值上加 1（当前节点所在的层）。
     * 3、递归返回：
     * 每次递归调用都会返回它的子树的最大深度，直到返回到最初的调用——从根节点开始的调用。
     * 最终，根节点的递归调用会返回整棵树的最大深度。
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            // // 如果节点为空，深度为0
            return 0;
        }
        // 计算左子树的深度
        int leftMaxDepth = maxDepth(root.left);
        // 计算右子树的深度
        int rightMaxDepth = maxDepth(root.right);
        // 返回较大的深度并加1（当前节点）
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }


    /**
     * // 记录当前遍历到的节点深度
     */
    int currentDepth = 0;
    /**
     * // 记录最大深度
     */
    int maxDepth = 0;

    /**
     * 回溯算法思路
     */
    public int maxDepthBackTrack(TreeNode root) {
        traverseTree(root);
        return maxDepth;
    }

    /**
     * 遍历树
     */
    void traverseTree(TreeNode root) {
        if (root == null) {
            // 到达叶子节点，更新最大深度
            maxDepth = Math.max(maxDepth, currentDepth);
            return;
        }
        // 进入当前节点时，深度值增加。
        currentDepth++;
        traverseTree(root.left);
        traverseTree(root.right);
        // 退出当前节点时，深度值恢复。
        currentDepth--;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        TreeUtil.printTree(root);

        System.out.println(new MaxDepth().maxDepthBackTrack(root));
        System.out.println(maxDepth(root));
    }
}
