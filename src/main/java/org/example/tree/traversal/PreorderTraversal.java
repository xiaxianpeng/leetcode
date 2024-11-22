package org.example.tree.traversal;

import java.util.LinkedList;
import java.util.List;

import org.example.tree.TreeNode;

/**
 * 二叉树的前序遍历
 * Created on 2024/11/22 19:40
 */
public class PreorderTraversal {

    /**
     * @param root 根
     * @return 前序遍历结果
     * 前序遍历
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverseTree(root, result);
        return result;
    }

    private static void traverseTree(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        traverseTree(node.left, result);
        traverseTree(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = preOrderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }
}
