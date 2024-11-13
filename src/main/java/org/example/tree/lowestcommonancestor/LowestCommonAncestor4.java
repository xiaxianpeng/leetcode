package org.example.tree.lowestcommonancestor;

import java.util.Arrays;
import java.util.List;

import org.example.tree.TreeNode;

/**
 * 1676. 二叉树的最近公共祖先IV
 * 题目描述
 * 给定一棵二叉树的根节点 root 和 TreeNode 类对象的数组（列表） nodes，
 * 返回 nodes 中所有节点的最近公共祖先（LCA）。
 * 数组（列表）中所有节点都存在于该二叉树中，且二叉树中所有节点的值都是互不相同的。
 * 我们扩展二叉树的最近公共祖先节点在维基百科上的定义：“对于任意合理的 i 值， n 个节点 p1 、 p2、...、 pn
 * 在二叉树 T 中的最近公共祖先节点是后代中包含所有节点 pi 的最深节点（我们允许一个节点是其自身的后代）”。
 * 一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
 * 输出: 2
 * 解释: 节点 4 和 7 的最近公共祖先是 2。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
 * 输出: 1
 * 解释: 单个节点的最近公共祖先是该节点本身。
 * 示例 3:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
 * 输出: 5
 * 解释: 节点 7、6、2 和 4 的最近公共祖先节点是 5。
 * 示例 4:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [0,1,2,3,4,5,6,7,8]
 * 输出: 3
 * 解释: 树中所有节点的最近公共祖先是根节点。
 * 提示:
 * 树中节点个数的范围是 [1, 104] 。
 * -109 <= Node.val <= 109
 * 所有的 Node.val 都是互不相同的。
 * 所有的 nodes[i] 都存在于该树中。
 * 所有的 nodes[i] 都是互不相同的。
 * Created on 2024/11/13 22:31
 */
public class LowestCommonAncestor4 {

    /**
     * 如果 nodes 数组（列表）只包含一个节点，那么该节点就是最近公共祖先。
     * 如果 nodes 数组（列表）包含多个节点，
     * 我们可以取出两个节点，找到它们的 LCA，
     * 然后将 LCA 与 nodes 数组（列表）中的下一个节点一起找新的 LCA。
     * 重复这个过程，直到处理完 nodes 数组（列表）中的所有节点。
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // 如果节点列表为空，返回 null
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        // 如果节点列表只有一个节点，返回这个节点
        if (nodes.size() == 1) {
            return nodes.get(0);
        }
        // 以列表中的第一个节点作为起始的 LCA
        TreeNode lca = nodes.get(0);
        // 遍历列表中的其余节点
        for (int i = 1; i < nodes.size(); i++) {
            lca = finLowestCommonAncestor(root, lca, nodes.get(i));
        }
        return lca;
    }

    private static TreeNode finLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        // 如果当前节点为空或等于 p 或 q，则返回当前节点
        if (node == null || node == p || node == q) {
            return node;
        }
        // 在左子树中寻找 p 和 q 的最近公共祖先
        TreeNode left = finLowestCommonAncestor(node.left, p, q);
        // 在右子树中寻找 p 和 q 的最近公共祖先
        TreeNode right = finLowestCommonAncestor(node.right, p, q);
        // 如果左右子树的返回值都不为空，说明 p 和 q 分别位于当前节点的两侧
        if (left != null && right != null) {
            return node;
        }
        // 如果左子树的返回值为空，说明 p 和 q 都不在左子树中，返回右子树的最近公共祖先
        // 如果右子树的返回值为空，说明 p 和 q 都在左子树中，返回左子树的最近公共祖先
        return left != null ? left : right;
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

        // 示例 1
        List<TreeNode> nodes1 = Arrays.asList(root.left.right.right, root.left.right.left); // 4, 7
        TreeNode lca1 = lowestCommonAncestor(root, nodes1);
        System.out.println("示例 1: 最近公共祖先是节点 " + lca1.val); // 输出 2

        // 示例 2
        List<TreeNode> nodes2 = Arrays.asList(root.right); // 1
        TreeNode lca2 = lowestCommonAncestor(root, nodes2);
        System.out.println("示例 2: 最近公共祖先是节点 " + lca2.val); // 输出 1

        // 示例 3
        List<TreeNode> nodes3 = Arrays.asList(root.left.right.left, root.left.left, root.left.right, root.left.right.right); // 7, 6, 2, 4
        TreeNode lca3 = lowestCommonAncestor(root, nodes3);
        System.out.println("示例 3: 最近公共祖先是节点 " + lca3.val); // 输出 5

        // 示例 4
        List<TreeNode> nodes4 = Arrays.asList(root.right.left, root.right, root.left.right, root,
                root.left.right.right, root.left, root.left.left, root.left.right.left, root.right.right); // 0, 1, 2, 3, 4, 5, 6, 7, 8
        TreeNode lca4 = lowestCommonAncestor(root, nodes4);
        System.out.println("示例 4: 最近公共祖先是节点 " + lca4.val); // 输出 3
    }
}
