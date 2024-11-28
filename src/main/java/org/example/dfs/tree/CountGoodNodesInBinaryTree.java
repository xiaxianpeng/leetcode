package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 1448. 统计二叉树中好节点的数目
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * 示例 1：
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * 示例 2：
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 * Created on 2024/11/18 18:08
 */
public class CountGoodNodesInBinaryTree {

    /**
     * 计算二叉树中好节点的数目。
     * 算法思路：
     * 1. 使用深度优先搜索（DFS）遍历树。
     * 2. 传递当前路径中的最大值。
     * 3. 如果当前节点值大于或等于路径中的最大值，则该节点是好节点。
     *
     * @param root 二叉树的根节点
     * @return 好节点的数目
     */
    public static int goodNodes(TreeNode root) {
        // 递归方法从根节点开始进行DFS遍历
        return countGoodNodes(root, root.val);
    }

    /**
     * 辅助方法：递归计算好节点的数目。
     *
     * @param node   当前节点
     * @param maxVal 当前路径上的最大值
     * @return 从当前节点开始的好节点数
     */
    private static int countGoodNodes(TreeNode node, int maxVal) {
        // 递归结束条件：当前节点为空
        if (node == null) {
            // 如果节点为空，返回0
            return 0;
        }

        // 判断当前节点是否是好节点
        int count = node.val >= maxVal ? 1 : 0;

        // 更新路径上的最大值
        maxVal = Math.max(maxVal, node.val);

        // 递归遍历左右子树
        count += countGoodNodes(node.left, maxVal);
        count += countGoodNodes(node.right, maxVal);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);

        TreeUtil.printTree(root1);
        System.out.println("GoodNodes: " + goodNodes(root1)); // 输出：4

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);

        TreeUtil.printTree(root2);
        System.out.println("GoodNodes: " + goodNodes(root2)); // 输出：3

        TreeNode root3 = new TreeNode(1);
        TreeUtil.printTree(root3);
        System.out.println("GoodNodes: " + goodNodes(root3)); // 输出：1
    }
}
