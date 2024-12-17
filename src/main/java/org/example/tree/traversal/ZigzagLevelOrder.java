package org.example.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.tree.TreeNode;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * Created on 2024/11/22 20:04
 */
public class ZigzagLevelOrder {

    /**
     * 使用队列实现二叉树的锯齿形层序遍历。
     * 算法思路：
     * 1. 使用队列进行层序遍历，每层记录节点值到双端队列中（Deque）。
     * - 如果当前层从左到右遍历，节点值加入队列尾部。
     * - 如果当前层从右到左遍历，节点值加入队列头部。
     * 2. 遍历完当前层后，将双端队列的结果转为普通列表，加入最终结果。
     * 3. 层级切换时，翻转遍历方向标志 `isOrderLeft`。
     * 时间复杂度：O(n)，其中 n 是树中节点的数量，每个节点被访问一次。
     * 空间复杂度：O(n)，队列中最多可能存储所有叶子节点。
     *
     * @param root 二叉树的根节点
     * @return 锯齿形层序遍历的节点值列表
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelList = new ArrayList<>();
        if (root == null) {
            return zigzagLevelList; // 空树返回空列表
        }

        // 使用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isOrderLeft = true;// 遍历方向标志，初始为从左到右

        while (!queue.isEmpty()) {
            LinkedList<Integer> levelQueue = new LinkedList<>();// 双端队列存储当前层节点值
            int size = queue.size();// 当前层的节点数

            for (int i = 0; i < size; i++) {
                // 取出队列头部的节点
                TreeNode curNode = queue.poll();

                // 根据遍历方向将节点值加入双端队列
                if (isOrderLeft) {// 如果从左到右：加入队列尾部
                    levelQueue.offerLast(curNode.val);
                } else {// 如果从右到左：加入队列头部
                    levelQueue.offerFirst(curNode.val);
                }

                // 将左右子节点加入队列
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            // 将当前层结果加入最终结果
            zigzagLevelList.add(levelQueue);
            // 切换遍历方向
            isOrderLeft = !isOrderLeft;
        }
        return zigzagLevelList;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println("Zigzag Level Order Traversal: " + result); // 输出: [[3], [20, 9], [15, 7]]
    }
}
