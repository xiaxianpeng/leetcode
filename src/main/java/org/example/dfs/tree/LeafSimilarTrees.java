package org.example.dfs.tree;

import java.util.ArrayList;
import java.util.List;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * Created on 2024/11/18 17:30
 */
public class LeafSimilarTrees {


    /**
     * 比较两棵树的叶子节点值序列是否相同
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 获取第一棵树的叶子节点序列
        List<Integer> leaves1 = new ArrayList<>();
        dfs(root1, leaves1);

        // 获取第二棵树的叶子节点序列
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root2, leaves2);

        // 比较两个叶子节点序列
        return leaves1.equals(leaves2);
    }

    /**
     * 深度优先遍历：获取树的叶子节点值并存储到list中
     */
    public static void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        // 如果是叶子节点，加入叶子值序列
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        // 递归遍历左右子树
        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }

    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);
        TreeUtil.printTree(root1);
        TreeUtil.printTree(root2);
        System.out.println(leafSimilar(root1, root2)); // 输出：true

        // 示例 2
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);
        TreeUtil.printTree(root3);
        TreeUtil.printTree(root4);
        System.out.println(leafSimilar(root3, root4)); // 输出：false
    }
}
