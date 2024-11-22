package org.example.tree.traversal;

import java.util.ArrayList;
import java.util.Deque;
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
     * @param root root
     * @return 锯齿形层序遍历
     * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;// 如果根节点为 null，直接返回空列表
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isOrderLeft = true;// 控制遍历方向，初始为从左到右
        while (!queue.isEmpty()) {
            // 双端队列存储每层val
            Deque<Integer> levelQueue = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft) {//如果从左至右，我们每次将被遍历到的元素插入至双端队列的末尾。
                    levelQueue.offerLast(curNode.val);
                } else {//如果从右至左，我们每次将被遍历到的元素插入至双端队列的头部。
                    levelQueue.offerFirst(curNode.val);
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            //
            ans.add(new LinkedList<>(levelQueue));// 当前层遍历结果加入最终答案
            isOrderLeft = !isOrderLeft;// 切换方向
        }
        return ans;
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