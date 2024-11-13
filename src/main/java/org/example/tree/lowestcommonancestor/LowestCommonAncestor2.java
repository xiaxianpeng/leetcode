package org.example.tree.lowestcommonancestor;

import org.example.tree.TreeNode;

/**
 * 1644. 二叉树的最近公共祖先 II
 * 题目描述
 * 给定一棵二叉树的根节点 root，返回给定节点 p 和 q 的最近公共祖先（LCA）节点。
 * 如果 p 或 q 之一 不存在 于该二叉树中，返回 null。树中的每个节点值都是互不相同的。
 * 根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是 后代节点 中
 * 既包括 p 又包括 q 的最深节点（我们允许 一个节点为自身的一个后代节点 ）”。
 * 一个节点 x 的 后代节点 是节点 x 到某一叶节点间的路径中的节点 y。
 * 示例 1:
 * 输入： root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出： 3
 * 解释： 节点 5 和 1 的共同祖先节点是 3。
 * 示例 2:
 * 输入： root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出： 5
 * 解释： 节点 5 和 4 的共同祖先节点是 5。根据共同祖先节点的定义，一个节点可以是自身的后代节点。
 * 示例 3:
 * 输入： root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
 * 输出： null
 * 解释： 节点 10 不存在于树中，所以返回 null。
 * 提示:
 * 树中节点个数的范围是 [1, 104]
 * -109 <= Node.val <= 109
 * 所有节点的值 Node.val 互不相同
 * p != q
 * Created on 2024/11/14 00:53
 */
public class LowestCommonAncestor2 {


    // 在二叉树中寻找 val1 和 val2 的最近公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = find(root, p, q);
        // 额外检查 p 和 q 是否存在于树中
        boolean pExists = exists(root, p);
        boolean qExists = exists(root, q);
        // 如果 p 和 q 都存在，则返回 LCA；否则返回 null
        return (pExists && qExists) ? lca : null;
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root; // 找到 p 或 q
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left != null && right != null) {
            return root; // 如果左右子树均非空，说明当前节点是 LCA
        }
        return left != null ? left : right; // 否则，返回非空的子树
    }

    private boolean exists(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        return exists(root.left, target) || exists(root.right, target);
    }

    public static void main(String[] args) {
        // 构建示例二叉树，节点值如题目所给
        TreeNode root = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        TreeNode p1 = new TreeNode(1);
        TreeNode p6 = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p0 = new TreeNode(0);
        TreeNode p8 = new TreeNode(8);
        TreeNode p7 = new TreeNode(7);
        TreeNode p4 = new TreeNode(4);

        root.left = p5;
        root.right = p1;
        p5.left = p6;
        p5.right = p2;
        p1.left = p0;
        p1.right = p8;
        p2.left = p7;
        p2.right = p4;

        // 创建解决方案实例
        LowestCommonAncestor2 solution = new LowestCommonAncestor2();

        // 示例 1: 查找节点 5 和节点 1 的 LCA
        TreeNode lca1 = solution.lowestCommonAncestor(root, p5, p1);
        System.out.println("示例 1: 节点 5 和节点 1 的最近公共祖先是节点 " + (lca1 != null ? lca1.val : "null")); // 应输出 3

        // 示例 2: 查找节点 5 和节点 4 的 LCA
        TreeNode lca2 = solution.lowestCommonAncestor(root, p5, p4);
        System.out.println("示例 2: 节点 5 和节点 4 的最近公共祖先是节点 " + (lca2 != null ? lca2.val : "null")); // 应输出 5

        // 示例 3: 查找节点 5 和不存在于树中的节点 10 的 LCA
        TreeNode p10 = new TreeNode(10); // 假设此节点不存在于树中
        TreeNode lca3 = solution.lowestCommonAncestor(root, p5, p10);
        System.out.println("示例 3: 节点 5 和节点 10 的最近公共祖先是节点 " + (lca3 != null ? lca3.val : "null")); // 应输出 null
    }
}
