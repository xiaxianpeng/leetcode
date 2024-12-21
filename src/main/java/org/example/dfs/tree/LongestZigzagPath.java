package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 1372. 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 * 示例 1：
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 * 输入：root = [1]
 * 输出：0
 * Created on 2024/12/21 13:51
 */
public class LongestZigzagPath {
    /**
     * 最大交错路径
     */
    int maxLength = 0;

    /**
     * 计算二叉树中的最长交错路径
     *
     * @param root 根节点
     * @return 二叉树中的最长交错路径
     */
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLength;
    }

    /**
     * 递归计算每个节点的最长交错路径
     *
     * @param node   当前节点
     * @param isLeft 如果是从左子节点出发，isLeft为true，否则为false
     * @param length 当前路径的长度
     */
    private void dfs(TreeNode node, boolean isLeft, int length) {
        // 如果当前节点为空，返回
        if (node == null) {
            return;
        }
        // 更新最长交错路径的长度
        maxLength = Math.max(maxLength, length);

        // 如果当前节点的方向是左->右，则向右子树递归，交错路径长度+1
        if (isLeft) {
            // 方向转向右
            dfs(node.right, false, length + 1);
            // 重启左->右的交错路径
            dfs(node.left, true, 1);
        }
        // 如果当前节点的方向是右->左，则向左子树递归，交错路径长度+1
        else {
            // 方向转向左
            dfs(node.left, true, length + 1);
            // 重启右->左的交错路径
            dfs(node.right, false, 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        root1.right.left.left = new TreeNode(1);
        root1.right.left.right = new TreeNode(1);
        root1.right.right.right = new TreeNode(1);
        root1.right.left.left.left = new TreeNode(1);
        root1.right.left.left.right = new TreeNode(1);
        root1.right.left.right.right = new TreeNode(1);
        root1.right.left.left.right.left = new TreeNode(1);
        TreeUtil.printTree(root1);
        System.out.println("longestZigZag: " + new LongestZigzagPath().longestZigZag(root1)); // 输出: 3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        root2.left.right.left = new TreeNode(1);
        root2.left.right.left.left = new TreeNode(1);
        root2.left.right.left.right = new TreeNode(1);
        TreeUtil.printTree(root2);
        System.out.println("longestZigZag: " + new LongestZigzagPath().longestZigZag(root2)); // 输出: 4

        TreeNode root3 = new TreeNode(1);
        TreeUtil.printTree(root3);
        System.out.println("longestZigZag: " + new LongestZigzagPath().longestZigZag(root3)); // 输出: 0
    }
}
