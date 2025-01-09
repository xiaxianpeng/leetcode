package org.example.dfs.tree;

import java.util.ArrayList;
import java.util.List;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 113. 路径总和II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * Created on 2025/1/9 22:44
 */
public class PathSum2 {

    /**
     * 寻找所有根节点到叶子节点路径总和等于目标和的路径
     *
     * @param root      二叉树的根节点
     * @param targetSum 目标路径和
     * @return 所有满足条件的路径列表
     * 算法思路：
     * 使用dfs遍历二叉树
     * 在遍历过程中，维护当前路径和以及当前路径的节点列表
     * 当遍历到叶子节点时，检查路径和是否等于目标和，如果是，则将该路径添加到结果列表中
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 存储所有满足条件的路径
        List<List<Integer>> results = new ArrayList<>();
        // 当前遍历的路径
        List<Integer> current = new ArrayList<>();
        // 开始DFS
        dfs(root, targetSum, current, results);
        return results;
    }

    /**
     * DFS辅助函数，用与遍历树并寻找满足条件的路径
     *
     * @param node      当前遍历的节点
     * @param remainSum 当前路径需要达到的剩余和
     * @param current   当前路径的节点列表
     * @param results   存储所有满足条件的路径的列表
     */
    private static void dfs(TreeNode node, int remainSum, List<Integer> current, List<List<Integer>> results) {
        if (node == null) {
            // 当前节点为空，无法继续遍历
            return;
        }

        // 将当前节点加入路径
        current.add(node.val);
        // 更新剩余需要的和
        int newRemainSum = remainSum - node.val;

        // 检查当前节点是否为叶子节点
        if (node.left == null && node.right == null) {
            // 找到一条满足条件的路径，添加到结果列表中
            if (node.val == remainSum) {
                results.add(new ArrayList<>(current));
            }
        } else {
            // 继续遍历左子树
            dfs(node.left, newRemainSum, current, results);
            // 继续遍历右子树
            dfs(node.right, newRemainSum, current, results);
        }
        // 回溯，移除当前节点
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        int targetSum1 = 22;
        TreeUtil.printTree(root1);
        System.out.println("所有满足路径: " + pathSum(root1, targetSum1));// 输出: [[5,4,11,2],[5,8,4,5]]

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        int targetSum2 = 5;
        TreeUtil.printTree(root2);
        System.out.println("所有满足路径: " + pathSum(root2, targetSum2)); // 输出: []

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        int targetSum3 = 0;
        TreeUtil.printTree(root3);
        System.out.println("所有满足路径: " + pathSum(root3, targetSum3));
    }
}
