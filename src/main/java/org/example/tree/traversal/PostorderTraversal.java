package org.example.tree.traversal;

import java.util.LinkedList;
import java.util.List;

import org.example.tree.TreeNode;

/**
 * 二叉树的后序遍历
 * Created on 2024/11/22 19:40
 */
public class PostorderTraversal {

    /**
     * @param root 根
     * @return 二叉树的后序遍历
     * 后序遍历
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverseTree(root, result);
        return result;
    }

    private static void traverseTree(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traverseTree(node.left, result);
        traverseTree(node.right, result);
        result.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = postorderTraversal(root);
        System.out.println("PostOrder Traversal: " + result);
    }
}
