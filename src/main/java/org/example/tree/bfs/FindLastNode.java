package org.example.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.example.tree.TreeNode;

/**
 * 完全二叉树：快速找到最后一个节点
 * Created on 2024/11/20 11:06
 */
public class FindLastNode {

    public static TreeNode findLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode lastNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            lastNode = queue.poll();
            // 将当前节点的左子节点入队
            if (lastNode.left != null) {
                queue.offer(lastNode.left);
            }
            // 将当前节点的右子节点入队
            if (lastNode.right != null) {
                queue.offer(lastNode.right);
            }
        }
        return lastNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        TreeNode lastNode = findLastNode(root);
        System.out.println("Final Last Node Value: " + lastNode.val);
    }
}
