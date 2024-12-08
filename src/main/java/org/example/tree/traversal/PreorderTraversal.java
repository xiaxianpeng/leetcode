package org.example.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.example.tree.TreeNode;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 解释：
 * 示例 2：
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 输出：[1,2,4,5,6,7,3,8,9]
 * 解释：
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 示例 4：
 * 输入：root = [1]
 * 输出：[1]
 * Created on 2024/11/22 19:40
 */
public class PreorderTraversal {

    /**
     * 使用递归方式实现二叉树的前序遍历。
     * 算法思路：
     * 1. 前序遍历的顺序为：根节点 -> 左子树 -> 右子树。
     * 2. 使用递归的方式分别访问当前节点、左子树和右子树。
     * 时间复杂度：O(n)，其中 n 是二叉树节点的数量，每个节点访问一次。
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，递归栈的深度取决于树的高度。
     *
     * @param root 二叉树的根节点
     * @return 按前序遍历的节点值列表
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preOrderList = new LinkedList<>();
        traverseTree(root, preOrderList);
        return preOrderList;
    }

    /**
     * 辅助方法，用于递归遍历二叉树并记录前序遍历结果。
     *
     * @param node         当前访问的节点
     * @param preOrderList 存储前序遍历结果的列表
     */
    private static void traverseTree(TreeNode node, List<Integer> preOrderList) {
        if (node == null) {
            return;// 空节点直接返回
        }
        preOrderList.add(node.val);// 访问当前节点
        traverseTree(node.left, preOrderList);// 递归遍历左子树
        traverseTree(node.right, preOrderList); // 递归遍历右子树
    }


    /**
     * 使用迭代方式实现二叉树的前序遍历。
     * 算法思路：
     * 1. 使用栈模拟递归过程，栈的特点是后进先出（LIFO）。
     * 2. 首先将根节点压入栈中，每次弹出栈顶节点，访问其值。
     * 3. 按顺序将右子节点和左子节点压入栈，保证左子树先于右子树被访问。
     * 时间复杂度：O(n)，其中 n 是二叉树节点的数量，每个节点访问一次。
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，栈的最大深度取决于树的高度。
     *
     * @param root 二叉树的根节点
     * @return 按前序遍历的节点值列表
     */
    public static List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        if (root == null) {
            return preOrderList;// 空树直接返回空列表
        }

        Stack<TreeNode> stack = new Stack<>();// 用作栈模拟递归
        stack.push(root);

        while (!stack.isEmpty()) {
            // 1. 弹出栈顶节点并访问
            TreeNode node = stack.pop();
            preOrderList.add(node.val);

            // 2. 按顺序压入右子节点和左子节点（栈是后进先出，保证左子树先访问）
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preOrderList;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = preOrderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
        List<Integer> result2 = preOrderTraversal2(root);
        System.out.println("Preorder Traversal: " + result2);
    }
}
