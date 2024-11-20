package org.example.tree.lowestcommonancestor;

import org.example.tree.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * * * *
 * 最近公共祖先的定义为：对于有根树的两个节点 p、q，
 * 最近公共祖先表示为⼀个节点 x，满⾜ x 是 p、q 的祖先且 x 的深度尽可能⼤（⼀个节点也可以是它⾃⼰的祖先）。
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * /**
 * * 经典问题了，先给出递归函数的定义：给该函数输⼊三个参数 root，p，q，
 * * 它会返回⼀个节点：
 * * 情况 1，如果 p 和 q 都在以 root 为根的树中，函数返回的即是 p 和 q 的最近公共祖先节点。
 * * 情况 2，那如果 p 和 q 都不在以 root 为根的树中怎么办呢？函数理所当然地返回 null 呗。
 * * 情况 3，那如果 p 和 q 只有⼀个存在于 root 为根的树中呢？函数就会返回那个节点。
 * * 根据这个定义，分情况讨论：
 * * 情况 1，如果 p 和 q 都在以 root 为根的树中，那么 left 和 right ⼀定分别是 p 和 q（从 base case 看出 来的）。
 * * 情况 2，如果 p 和 q 都不在以 root 为根的树中，直接返回 null。
 * * 情况 3，如果 p 和 q 只有⼀个存在于 root 为根的树中，函数返回该节点。
 */
public class LowestCommonAncestor {

    /**
     * 找到二叉树中两个节点的最近公共祖先。
     *
     * @param node 当前递归节点
     * @param p    第一个节点
     * @param q    第二个节点
     * @return 最近公共祖先节点
     */
    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {

        // base case
        // 如果当前节点为空，或者等于p或q，则返回当前节点
        if (node == null) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }

        // 在左子树中寻找p和q的最近公共祖先
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        // 在右子树中寻找p和q的最近公共祖先
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        // 情况1
        // 如果左右子树的返回值都不为空，说明p和q分别位于当前节点的两侧
        if (left != null && right != null) {
            return node; // 因此，该节点即为最近公共祖先
        }
        // 情况2
        // 如果左右子树的递归返回结果都是null，说明p和q都不在当前节点为根的子树中
        if (left == null && right == null) {
            return null;// 返回null
        }
        // 情况3
        // 如果左子树的递归返回了一个非null节点（即找到了p或q），而右子树返回null
        // 那么最近公共祖先一定在左子树
        // 反之亦然，如果右子树的递归返回了一个非null节点，最近公共祖先一定在右子树
        return left != null ? left : right;// 返回非null的那个子树调用结果
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // 示例 1: 寻找节点 5 和节点 1 的最近公共祖先
        TreeNode p = root.left; // 节点 5
        TreeNode q = root.right; // 节点 1
        TreeNode lca1 = lowestCommonAncestor(root, p, q);
        System.out.println("示例 1: 最近公共祖先是节点 " + lca1.val); // 期望输出是节点 3

        // 示例 2: 寻找节点 5 和节点 4 的最近公共祖先
        p = root.left; // 节点 5
        q = root.left.right.right; // 节点 4
        TreeNode lca2 = lowestCommonAncestor(root, p, q);
        System.out.println("示例 2: 最近公共祖先是节点 " + lca2.val); // 期望输出是节点 5

        // 示例 3: 寻找节点 1 和节点 2 的最近公共祖先
        p = root.right; // 节点 1
        q = root.left.right; // 节点 2
        TreeNode lca3 = lowestCommonAncestor(root, p, q);
        System.out.println("示例 3: 最近公共祖先是节点 " + lca3.val); // 期望输出是节点 3
    }
}
