package org.example.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.example.tree.TreeNode;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * 示例 1：
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * Created on 2024/11/18 19:44
 */
public class MaxLevelSum {
    public static int maxLevelSum(TreeNode root) {
        // 空树返回 0
        if (root == null) {
            return 0;
        }
        // 初始化 BFS 所需队列和变量
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 最大和
        int maxSum = Integer.MIN_VALUE;
        // 最大和对应的层号
        int maxLevel = 1;
        // 当前层号
        int curLevel = 1;

        // 开始 BFS 遍历
        while (!queue.isEmpty()) {
            // 当前层的节点数
            int nodeSize = queue.size();
            // 当前层的元素和
            int curSum = 0;

            // 遍历当前层所有节点
            for (int i = 0; i < nodeSize; i++) {
                TreeNode cur = queue.poll();
                // 累加当前层节点值
                curSum += cur.val;

                // 将左右子节点加入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println("\n第 " + curLevel + " 层总和：" + curSum); // 打印当前层总和

            // 更新最大和与对应层号
            if (curSum > maxSum) {
                maxSum = Math.max(maxSum, curSum);
                maxLevel = curLevel;
                System.out.println("更新最大层和：" + maxSum + "，层号：" + maxLevel);
            }
            // 进入下一层
            curLevel++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(-8);
        System.out.println("最大层内元素和：" + maxLevelSum(root1));

        // 示例 2
        TreeNode root2 = new TreeNode(989);
        root2.right = new TreeNode(10250);
        root2.right.left = new TreeNode(98693);
        root2.right.right = new TreeNode(-89388);
        root2.right.right.right = new TreeNode(-32127);
        System.out.println("最大层内元素和：" + maxLevelSum(root2));
    }
}
