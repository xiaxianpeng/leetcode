package org.example.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的根节点 root，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * 输入: []
 * 输出: []
 */
public class RightSideView {

    /**
     * 使用广度优先搜索(BFS)获取二叉树的右视图。
     * 每层最后一个节点即为该层右视图的节点。
     *
     * @param root 二叉树的根节点
     * @return 从右侧所能看到的节点值列表
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if (root == null) {
            return rightSideView; // 空树返回空列表
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 如果是当前层的最后一个节点，将其值加入结果
                if (i == size - 1) {
                    rightSideView.add(node.val);
                }

                // 将左子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 将右子节点加入队列
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightSideView;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        TreeUtil.printTree(root1);
        System.out.println("Right side view of Tree 1: " + rightSideView(root1)); // 输出：[1, 3, 4]

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(5);
        TreeUtil.printTree(root2);
        System.out.println("Right side view of Tree 2: " + rightSideView(root2)); // 输出：[1, 3, 4, 5]

        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(3);
        TreeUtil.printTree(root3);
        System.out.println("Right side view of Tree 3: " + rightSideView(root3)); // 输出：[1, 3]

        TreeNode root4 = null;
        TreeUtil.printTree(root4);
        System.out.println("Right side view of Tree 4: " + rightSideView(root4)); // 输出：[]
    }
}
