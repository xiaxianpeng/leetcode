package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xianpeng.xia
 * on 2022/3/28 10:35 PM
 *
 * 给定⼀个⼆叉树，找出其最⼩深度，
 * 最⼩深度是从根节点到最近叶⼦节点（没有⼦节点的节点）的最短路径 上的节点数量。
 * 输⼊：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // root本身就是一层，depth初始化为1
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层的节点
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 将下一层节点加入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 增加步数
            depth++;
        }
        return depth;
    }
}
