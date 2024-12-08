package org.example.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.example.tree.TreeNode;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * Created on 2024/11/22 19:32
 */
public class InorderTraversal {

    /**
     * 使用递归实现中序遍历
     *
     * 算法思路：
     * 1. 递归遍历左子树，访问其所有节点。
     * 2. 访问当前节点，将其值添加到结果列表中。
     * 3. 递归遍历右子树，访问其所有节点。
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数，每个节点被访问一次。
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，递归栈的深度与树的高度相关。
     *
     * @param root 二叉树的根节点
     * @return 中序遍历结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        traverseTree(root, result);
        return result;
    }

    /**
     * 辅助递归方法，执行中序遍历
     *
     * @param node 当前访问的节点
     * @param result 用于存储中序遍历结果的列表
     */
    private static void traverseTree(TreeNode node, LinkedList<Integer> result) {
        if (node == null) {
            return;
        }
        // 递归遍历左子树
        traverseTree(node.left, result);
        // 访问当前节点
        result.add(node.val);
        // 递归遍历右子树
        traverseTree(node.right, result);
    }

    /**
     * 使用迭代方式实现二叉树的中序遍历。
     *
     * 算法思路：
     * 1. 借助栈模拟递归，先将左子树节点依次压入栈中。
     * 2. 弹出栈顶节点（即当前中序节点），访问其值。
     * 3. 如果该节点有右子树，将右子树作为下一步的访问目标。
     *
     * 时间复杂度：O(n)，其中 n 是二叉树节点的数量，每个节点访问一次。
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，栈的最大深度取决于树的高度。
     *
     * @param node 二叉树的根节点
     * @return 按中序遍历的节点值列表
     */
    public static List<Integer> inorderTraversal2(TreeNode node) {
        List<Integer> result = new ArrayList<>(); // 存储遍历结果
        Stack<TreeNode> stack = new Stack<>();// 用作栈模拟递归

        // 使用循环进行迭代遍历
        while (node != null || !stack.isEmpty()) {

            // 1. 依次将当前节点及其左子节点压入栈
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            // 2. 弹出栈顶节点（当前节点）
            node = stack.pop();
            result.add(node.val);// 访问当前节点

            // 3. 转向右子树
            node = node.right;
        }

        return result;
    }


    public static void main(String[] args) {
        //二叉树：[2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
        List<Integer> result2 = inorderTraversal2(root);
        System.out.println("Inorder Traversal: " + result2);

    }
}
