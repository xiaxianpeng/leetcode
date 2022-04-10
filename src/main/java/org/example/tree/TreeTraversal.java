package org.example.tree;

import java.util.ArrayList;
import java.util.Deque;
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
    public List<Integer> inorderTraversal(TreeNode root) {
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
    public List<Integer> preOrderTraversal(TreeNode root) {
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
    public List<Integer> postorderTraversal(TreeNode root) {
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
    public List<Integer> levelOrderTraversal(TreeNode root) {
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
                TreeNode cur = queue.poll();
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

    /**
     * @param root root
     * @return 锯齿形层序遍历
     *
     * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 默认根节点层数为0，层数为偶数
        boolean isOrderLeft = true;
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
            ans.add(new LinkedList<>(levelQueue));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }
}
