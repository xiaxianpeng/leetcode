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
    public static int maxDepth_(TreeNode root) {
        if (root == null) {
            // // 如果节点为空，深度为0
            return 0;
        }
        // 计算左子树的深度
        int leftMaxDepth = maxDepth_(root.left);
        // 计算右子树的深度
        int rightMaxDepth = maxDepth_(root.right);
        // 返回较大的深度并加1（当前节点）
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
