package org.example.tree.lowestcommonancestor;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
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
     * 解题思路：
     * 1. 使用递归来查找最近公共祖先。
     * 2. 递归的返回条件：当找到目标节点p或q时，返回当前节点；若两子树都包含目标节点，则当前节点为公共祖先。
     * 3. 递归时处理左右子树，通过返回非空节点来决定公共祖先的选择。
     * 4. 终止条件：如果当前节点为空或等于p或q，返回当前节点。
     * 时间复杂度：O(N)，其中N是树的节点数。
     * 空间复杂度：O(H)，H为树的高度，递归调用栈的最大深度。
     */
    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {

        // 如果当前节点为空，或当前节点为p或q，返回当前节点
        if (node == null || node == p || node == q) {
            return node;
        }

        // 递归查找左子树
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        // 递归查找右子树
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        // 如果左右子树都不为空，当前节点就是最近公共祖先
        if (left != null && right != null) {
            return node; // 因此，该节点即为最近公共祖先
        }
        // 否则，返回非空的那一侧
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

        TreeUtil.printTree(root);

        // 寻找节点 5 和节点 1 的最近公共祖先
        TreeNode p = root.left; // 节点 5
        TreeNode q = root.right; // 节点 1
        TreeNode lca1 = lowestCommonAncestor(root, p, q);
        System.out.println("5,1最近公共祖先是节点 " + lca1.val); // 期望输出是节点 3

        // 寻找节点 5 和节点 4 的最近公共祖先
        p = root.left; // 节点 5
        q = root.left.right.right; // 节点 4
        TreeNode lca2 = lowestCommonAncestor(root, p, q);
        System.out.println("5,4最近公共祖先是节点 " + lca2.val); // 期望输出是节点 5

        // 寻找节点 1 和节点 2 的最近公共祖先
        p = root.right; // 节点 1
        q = root.left.right; // 节点 2
        TreeNode lca3 = lowestCommonAncestor(root, p, q);
        System.out.println("1,2最近公共祖先是节点 " + lca3.val); // 期望输出是节点 3
    }
}
