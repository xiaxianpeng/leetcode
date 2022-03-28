package org.example.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xianpeng.xia
 * on 2022/3/28 7:28 PM
 * 二叉树遍历
 */
public class TreeTraversal {

    /**
     * @param root 根
     * @return 中序遍历结果
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    /**
     * @param root 根
     * @return 前序遍历结果
     * 前序遍历
     */
    public List<Integer> preOrderTraversal(TreeNode<Integer> root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preOrderTraversal(root.left));
        res.addAll(preOrderTraversal(root.right));
        return res;
    }

    /**
     * @param root 根
     * @return 后序遍历结果
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode<Integer> root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    /**
     * @param root 根
     * @return 后序遍历结果
     * 后序遍历
     */
    public List<Integer> levelOrderTraversal(TreeNode<Integer> root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // while循环从上到下一层层遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            // for循环控制每一层从左到右遍历
            for (int s = 0; s < size; s++) {
                TreeNode<Integer> cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                res.addAll(level);
            }
        }
        return res;
    }
}
