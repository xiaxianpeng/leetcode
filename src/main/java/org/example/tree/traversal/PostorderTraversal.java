package org.example.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.example.tree.TreeNode;

/**
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 解释：
 * 示例 2：
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 输出：[4,6,7,5,2,9,8,3,1]
 * 解释：
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 示例 4：
 * 输入：root = [1]
 * 输出：[1]
 * Created on 2024/11/22 19:40
 */
public class PostorderTraversal {

    /**
     * 使用递归方式实现二叉树的后序遍历。
     * 算法思路：
     * 1. 后序遍历的顺序为：左子树 -> 右子树 -> 根节点。
     * 2. 使用递归的方式分别访问左子树、右子树和当前节点。
     * 时间复杂度：O(n)，其中 n 是二叉树节点的数量，每个节点访问一次。
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，递归栈的深度取决于树的高度。
     *
     * @param root 二叉树的根节点
     * @return 按后序遍历的节点值列表
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new LinkedList<>();
        traverseTree(root, postOrderList);
        return postOrderList;
    }

    /**
     * 辅助方法，用于递归遍历二叉树并记录后序遍历结果。
     *
     * @param node          当前访问的节点
     * @param postOrderList 存储后序遍历结果的列表
     */
    private static void traverseTree(TreeNode node, List<Integer> postOrderList) {
        if (node == null) {
            return; // 空节点直接返回
        }
        traverseTree(node.left, postOrderList); // 递归遍历左子树
        traverseTree(node.right, postOrderList); // 递归遍历右子树
        postOrderList.add(node.val); // 访问当前节点
    }

    /**
     * 使用迭代方式实现二叉树的后序遍历。
     * 算法思路：
     * 1. 使用两个栈来模拟递归过程：
     * - 第一个栈用于遍历二叉树，访问节点顺序为：根 -> 右子树 -> 左子树。
     * - 第二个栈用于存储节点的访问顺序，最终输出为后序遍历的结果。
     * 时间复杂度：O(n)，其中 n 是二叉树节点的数量，每个节点访问一次。
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，栈的最大深度取决于树的高度。
     *
     * @param root 二叉树的根节点
     * @return 按后序遍历的节点值列表
     */
    public static List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        if (root == null) {
            return postOrderList;// 空树直接返回空列表
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        // 将根节点压入第一个栈
        stack1.push(root);

        while (!stack1.isEmpty()) {

            // 从第一个栈弹出节点
            TreeNode node = stack1.pop();
            // 压入第二个栈
            stack2.push(node);

            // 按顺序将左子节点和右子节点压入第一个栈
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }

        }

        // 第二个栈的弹出顺序即为后序遍历
        while (!stack2.isEmpty()) {
            postOrderList.add(stack2.pop().val);
        }

        return postOrderList;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> postOrderList = postorderTraversal(root);
        System.out.println("PostOrder Traversal: " + postOrderList);
        List<Integer> postOrderList2 = postOrderTraversal2(root);
        System.out.println("PostOrder Traversal2:" + postOrderList2);
    }
}
