package org.example.tree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.tree.TreeNode;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * Created on 2024/11/22 19:47
 */
public class LevelOrderTraversal {


    /**
     * 使用队列实现二叉树的层序遍历。
     * 算法思路：
     * 1. 使用队列进行广度优先搜索（BFS），每次记录当前层的节点值。
     * 2. 遍历当前层的所有节点，并将其子节点加入队列。
     * 3. 最终返回所有层的节点值列表。
     * 时间复杂度：O(n)，其中 n 是树中节点的数量，每个节点被访问一次。
     * 空间复杂度：O(n)，队列中最多可能存储所有叶子节点。
     *
     * @param root 二叉树的根节点
     * @return 层序遍历结果，分层的节点值列表
     */
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> levelOrderList = new LinkedList<>();
        if (root == null) {
            return levelOrderList; // 如果根节点为 null，直接返回空列表
        }

        // 使用队列来进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 记录当前层的节点值
            int size = queue.size();
            List<Integer> curLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                // 取出队列头部的节点
                TreeNode node = queue.poll();
                curLevel.add(node.val);

                // 如果左子节点不为空，放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // 如果右子节点不为空，放入队列
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 将当前层的结果添加到总结果中
            levelOrderList.addAll(curLevel);
        }
        return levelOrderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = levelOrderTraversal(root);
        System.out.println("LevelOrder Traversal: " + result);
    }
}
