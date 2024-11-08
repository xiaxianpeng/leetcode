package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;

/**
 * 230. 二叉搜索树中第 K 小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 3
 * /   \
 * 1     4
 * \
 * 2
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * /    \
 * 3     6
 * /   \
 * 2     4
 * /
 * 1
 * 输出：3
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/8 19:12
 */
public class KthSmallestElement {

    /**
     * 在二叉搜索树中，任意子节点都满足“左子节点 < 根节点 < 右子节点”的规则。因此二叉搜索树具有一个重要性质：二叉搜索树的中序遍历为递增序列。
     * 也就是说，本题可被转化为求中序遍历的第 k 个节点。
     * ***
     * 为求第 k 个节点，需要实现以下三项工作：
     * 递归遍历时计数，统计当前节点的序号。
     * 递归到第 k 个节点时，应记录结果 result 。
     * 记录结果后，后续的遍历即失去意义，应提前返回。
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2361685/230-er-cha-sou-suo-shu-zhong-di-k-xiao-d-n3he/?envType=study-plan-v2&envId=labuladong-algorithm-note
     */
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            // 如果节点为空，则返回
            return;
        }
        // 先访问左子树
        inorder(node.left, k);
        // 中序遍历的 "访问" 部分begin
        count++;
        if (count == k) {
            // 如果计数器等于 k，则找到了第 k 小的元素
            result = node.val;
            // 找到后就可以提前结束遍历
            return;
        }
        // 中序遍历的 "访问" 部分end
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(3));
        int k = 2;
        System.out.println(k + " kth = " + new KthSmallestElement().kthSmallest(root, k));
    }
}
