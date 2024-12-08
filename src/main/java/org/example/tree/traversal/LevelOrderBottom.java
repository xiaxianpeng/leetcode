package org.example.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * x
 * 输入：root = []
 * 输出：[]
 * Created on 2024/12/8 11:02
 */
public class LevelOrderBottom {

    /**
     * 使用队列实现二叉树的层序遍历，从底向上返回结果。
     * 算法思路：
     * 1. 使用队列进行层序遍历，逐层记录节点值。
     * 2. 每层的结果存入列表，并在最终结果列表中插入到最前面，实现“自底向上”的效果。
     * 时间复杂度：O(n)，其中 n 是二叉树节点的数量，每个节点访问一次。
     * 空间复杂度：O(n)，队列中最多存储当前层的节点数。
     *
     * @param root 二叉树的根节点
     * @return 自底向上的层序遍历结果
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderBottomList = new LinkedList<>();// 使用 LinkedList，方便头部插入
        if (root == null) {
            return levelOrderBottomList;// 空树直接返回空列表
        }

        Queue<TreeNode> queue = new LinkedList<>(); // 队列用于层序遍历
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();// 当前层的节点数
            List<Integer> currentLevel = new ArrayList<>();// 存储当前层的节点值

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();// 取出队列头部节点
                currentLevel.add(node.val);// 添加当前节点值到当前层列表

                if (node.left != null) {
                    queue.offer(node.left); // 左子节点入队
                }
                if (node.right != null) {
                    queue.offer(node.right);// 右子节点入队
                }
            }

            // 将当前层结果插入到结果列表的开头
            levelOrderBottomList.add(0, currentLevel);
        }

        return levelOrderBottomList;
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeUtil.printTree(root);
        List<List<Integer>> levelOrderBottomList = levelOrderBottom(root);
        // 输出: [[15,7],[9,20],[3]]
        System.out.println("Level Order Bottom Traversal: " + levelOrderBottomList);

    }
}
