package org.example.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * 示例 1：
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 * Created on 2024/12/26 22:58
 */
public class WidthOfBinaryTree {

    /**
     * 计算二叉树的最大宽度
     *
     * @param root 根节点
     * @return 最大宽度
     * 算法思想：
     * 采用层序遍历的方式，使用队列来存储每层的节点
     * 在每一层中，记录最左和最右非空节点的索引差值，来计算该层的宽度
     */
    public static int widthOfBinaryTree(TreeNode root) {
        // 空树宽度为0
        if (root == null) {
            return 0;
        }

        // 初始化最大宽度为0
        Integer maxWidth = 0;

        // 队列存储当前层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 队列存储节点的索引
        Queue<Integer> indexQueue = new LinkedList<>();
        indexQueue.offer(0);

        // 层序遍历
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int size = queue.size();
            // 当前层最左端节点的索引
            Integer leftIndex = indexQueue.peek();
            // 初始化当前层最右端节点的索引为最左端节点的索引
            Integer rightIndex = leftIndex;

            for (int i = 0; i < size; i++) {
                // 取出队列中的节点
                TreeNode node = queue.poll();
                // 取出对应的索引
                Integer index = indexQueue.poll();
                // 更新当前层左右端的索引
                rightIndex = index;

                // 如果左子节点存在，将其加入队列，并计算其在满二叉树的索引
                if (node.left != null) {
                    queue.offer(node.left);
                    indexQueue.offer(2 * index + 1);// 左子节点的索引为2*index+1
                }
                // 如果右子节点存在，将其加入队列，并计算其在满二叉树的索引
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQueue.offer(2 * index + 2);// 右子节点的索引为2*index+2
                }
            }
            // 计算当前层的宽度，并更新最大宽度
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }

        // 返回最大宽度
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        TreeUtil.printTree(root1);
        System.out.println(widthOfBinaryTree(root1));  // 输出 4

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        root2.right.right = new TreeNode(9);
        root2.left.left.left = new TreeNode(6);
        root2.right.right.left = new TreeNode(7);
        TreeUtil.printTree(root2);
        System.out.println(widthOfBinaryTree(root2));  // 输出 7

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(5);
        TreeUtil.printTree(root3);
        System.out.println(widthOfBinaryTree(root3));  // 输出 2
    }
}
