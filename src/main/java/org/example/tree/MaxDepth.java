package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 8:26 PM
 * ⼆叉树的最⼤深度
 */
public class MaxDepth {

    int depth = 0;
    int res = 0;

    /**
     * 回溯算法思路
     */
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }


    /**
     * 回溯算法思路
     * 输⼊⼀个节点，返回以该节点为根的⼆叉树的最⼤深度
     */
    public int maxDepth_(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth_(root.left);
        int rightMaxDepth = maxDepth_(root.right);
        // 根据左右⼦树的最⼤深度推出原⼆叉树的最⼤深度
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}
