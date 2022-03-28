package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/29 12:19 AM
 *
 * ⼆叉树的最近公共祖先
 * 最近公共祖先的定义为：对于有根树的两个节点 p、q，
 * 最近公共祖先表示为⼀个节点 x，满⾜ x 是 p、q 的祖先且 x 的深度尽可能⼤（⼀个节点也可以是它⾃⼰的祖先）。
 */
public class LowestCommonAncestor {

    /**
     * @param root root
     * @param p p
     * @param q q
     * @return 经典问题了，先给出递归函数的定义：给该函数输⼊三个参数 root，p，q，
     * 它会返回⼀个节点：
     * 情况 1，如果 p 和 q 都在以 root 为根的树中，函数返回的即使 p 和 q 的最近公共祖先节点。
     * 情况 2，那如果 p 和 q 都不在以 root 为根的树中怎么办呢？函数理所当然地返回 null 呗。
     * 情况 3，那如果 p 和 q 只有⼀个存在于 root 为根的树中呢？函数就会返回那个节点。
     *
     * 根据这个定义，分情况讨论：
     * 情况 1，如果 p 和 q 都在以 root 为根的树中，那么 left 和 right ⼀定分别是 p 和 q（从 base case 看出 来的）。
     * 情况 2，如果 p 和 q 都不在以 root 为根的树中，直接返回 null。
     * 情况 3，如果 p 和 q 只有⼀个存在于 root 为根的树中，函数返回该节点。
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1
        if (left != null && right != null) {
            return root;
        }
        // 情况2
        if (left == null && right == null) {
            return null;
        }
        // 情况3
        return left == null ? right : left;
    }
}
