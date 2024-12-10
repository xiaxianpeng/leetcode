package org.example.tree.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.tree.TreeNode;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root ,
 * 以数组的形式返回每一层节点的平均值。
 * 与实际答案相差 10-5 以内的答案可以被接受。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * 示例 2:
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * Created on 2024/12/10 12:36
 */
public class AverageOfLevels {

    /**
     * 计算二叉树每一层的平均值。
     * 算法思路：
     * 1. 使用广度优先搜索（BFS）遍历二叉树。
     * 2. 对于每一层，计算节点值的总和并除以节点数，得到平均值。
     * 3. 将每一层的平均值添加到结果列表中。
     * 4. 最后将结果列表转换为数组返回。
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<>();
        if (root == null) {
            return averages;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            double average = sum / size;
            averages.add(average);
        }
        return averages;
    }

    public static void main(String[] args) {

        // 二叉树 [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        List<Double> averages1 = averageOfLevels(root1);
        System.out.println("每层的平均值: " + averages1);
        System.out.println();

        // 二叉树 [3,9,20,15,7]
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.left.left = new TreeNode(15);
        root2.left.right = new TreeNode(7);

        List<Double> averages2 = averageOfLevels(root2);
        System.out.println("每层的平均值: " + averages2);
        System.out.println();

        TreeNode root3 = null;

        List<Double> averages3 = averageOfLevels(root3);
        System.out.println("每层的平均值: " + averages3);
    }
}
