package org.example.tree.lowestcommonancestor;

import org.example.tree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身
 * Created on 2024/11/13 23:13
 */
public class BstLowestCommonAncestor {

    /**
     * 算法思路：
     * 1. 从根节点开始搜索。
     * 2. 如果当前节点值(root.val)大于两个节点的值(firstNode.val 和 secondNode.val)，则最近公共祖先在当前节点的左子树。
     * 3. 如果当前节点值小于两个节点的值，则最近公共祖先在当前节点的右子树。
     * 4. 如果一个节点值大于等于当前节点值，而另一个小于等于，则当前节点就是最近公共祖先。
     */
    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        // 如果当前节点的值大于两个节点的值，则最近公共祖先在左子树
        if (node.val > p.val && node.val > q.val) {
            return lowestCommonAncestor(node.left, p, q);
        }
        // 如果当前节点的值小于两个节点的值，则最近公共祖先在右子树
        else if (node.val < p.val && node.val < q.val) {
            return lowestCommonAncestor(node.right, p, q);
        }
        // 如果一个节点的值大于等于当前节点值，而另一个小于等于，则当前节点是最近公共祖先
        else {
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(6);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(0);
        treeRoot.left.right = new TreeNode(4);
        treeRoot.left.right.left = new TreeNode(3);
        treeRoot.left.right.right = new TreeNode(5);
        treeRoot.right.left = new TreeNode(7);
        treeRoot.right.right = new TreeNode(9);

        // 示例 1: 查找节点 2 和节点 8 的 LCA
        TreeNode node2 = treeRoot.left; // 节点 2
        TreeNode node8 = treeRoot.right; // 节点 8
        TreeNode lca1 = lowestCommonAncestor(treeRoot, node2, node8);
        System.out.println("示例 1: 节点 2 和节点 8 的最近公共祖先是节点 " + lca1.val); // 应输出 6

        // 示例 2: 查找节点 2 和节点 4 的 LCA
        TreeNode node4 = treeRoot.left.right; // 节点 4
        TreeNode lca2 = lowestCommonAncestor(treeRoot, node2, node4);
        System.out.println("示例 2: 节点 2 和节点 4 的最近公共祖先是节点 " + lca2.val); // 应输出 2
    }
}
