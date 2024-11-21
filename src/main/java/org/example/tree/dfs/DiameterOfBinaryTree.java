package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 543. 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示 。
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/9 23:58
 */
public class DiameterOfBinaryTree {
    private int ans;

    /**
     * ans 初始化为 1，因为算法中使用节点的数量来表示直径，然后在最后返回结果时减去 1，把结果转换为边的数量。
     * 在 depth 方法中，对于每一个非空节点，计算左右子树的深度（L 和 R）。
     * 使用 L + R + 1 更新 ans 变量，这里 +1 是为了包含当前节点，以此计算经过当前节点的路径长度。
     * depth 方法返回的是以当前节点为根的子树的深度，即左右子树深度的最大值加上当前节点自身（+1）。
     * 这是为了上层递归能正确计算经过父节点的路径长度
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // ans 初始化为 1，因为使用节点的数量来表示直径，然后在最后返回结果时减去 1，把结果转换为边的数量。
        // // 初始化为 1 是为了方便计算节点间边的数量
        ans = 0;
        depth(root);
        // 由于ans初始化为1，返回结果时需要减1得到边的数量
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            // 访问到空节点了，返回0
            return 0;
        }
        // 左儿子为根的子树的深度
        int leftDepth = depth(node.left);
        // 右儿子为根的子树的深度
        int rightDepth = depth(node.right);
        // 计算节点node为根时，经过节点的路径长度 L+R+1 并更新ans
        ans = Math.max(ans, leftDepth + rightDepth + 1);
        // 返回该节点为根的子树的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeUtil.printTree(root);
        int diameter = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println("二叉树的直径是: " + diameter);
    }
}
