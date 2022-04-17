package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 8:26 PM
 * ⼆叉树的最⼤深度
 */
public class MaxDepth {

    /**
     * // 记录遍历到的节点的深度
     */
    int depth = 0;
    /**
     * // 记录最大深度
     */
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
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
            return;
        }
        // 前序遍历位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }


    /**
     * dp算法思路
     * 输⼊⼀个节点，返回以该节点为根的⼆叉树的最⼤深度
     */
    public static int maxDepth_(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth_(root.left);
        int rightMaxDepth = maxDepth_(root.right);
        // 根据左右⼦树的最⼤深度推出原⼆叉树的最⼤深度
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        System.out.println(new MaxDepth().maxDepth(root));
        System.out.println(maxDepth_(root));
    }
}
