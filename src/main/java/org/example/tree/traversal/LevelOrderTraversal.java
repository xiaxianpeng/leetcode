package org.example.tree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.tree.TreeNode;

/**
 * 二叉树的层序遍历
 * Created on 2024/11/22 19:47
 */
public class LevelOrderTraversal {


    /**
     * @param root 根
     * @return 层序遍历多叉树
     * 层序遍历多叉树
     */
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result; // 如果根节点为 null，直接返回空列表
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
            result.addAll(curLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = levelOrderTraversal(root);
        System.out.println("LevelOrder Traversal: " + result);
    }
}
