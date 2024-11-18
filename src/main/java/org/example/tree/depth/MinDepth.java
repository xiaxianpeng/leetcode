package org.example.tree.depth;

import java.util.LinkedList;
import java.util.Queue;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * @author xianpeng.xia
 * on 2022/3/28 10:35 PM
 * <p>
 * 给定⼀个⼆叉树，找出其最⼩深度，
 * 最⼩深度是从根节点到最近叶⼦节点（没有⼦节点的节点）的最短路径 上的节点数量。
 * 输⼊：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class MinDepth {

    /**
     * 算法思路：
     * 使用广度优先搜索（BFS）来查找最小深度。
     * 1. 初始化队列，开始从根节点遍历。
     * 2. 遍历每一层节点，检查每个节点的左右子树。
     * 3. 如果当前节点是叶子节点，直接返回当前的深度。
     * 4. 如果遍历完所有节点且没有叶子节点，则继续遍历下一层。
     */
    public static int minDepth(TreeNode root) {
        // 如果根节点为空，则树的深度为0
        if (root == null) {
            return 0;
        }

        // 初始化队列用于广度优先搜索（BFS）
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // root本身就是一层，depth初始化为1
        int depth = 1;

        // 开始广度优先搜索
        while (!queue.isEmpty()) {
            // 当前层节点数
            int size = queue.size();

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 如果当前节点是叶子节点，则返回当前深度
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 如果左子树存在，则加入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                // 如果右子树存在，则加入队列
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 遍历完当前层，深度加1
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        TreeUtil.printTree(root1);
        System.out.println("最小深度: " + minDepth(root1)); // 输出: 2

        System.out.println();

        // 示例 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        TreeUtil.printTree(root2);
        System.out.println("最小深度: " + minDepth(root2)); // 输出: 2
    }
}
