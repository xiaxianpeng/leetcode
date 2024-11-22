package org.example.tree.dfs;

import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/4/7 12:39 PM
 *
 * 530. ⼆叉搜索树的最⼩绝对差
 *
 * 给你⼀个⼆叉搜索树的根节点 root，
 * 返回树中任意两不同节点值之间的最⼩差值。
 * 差值是⼀个正数，其数值 等于两值之差的绝对值。
 */
public class GetMinimumDifference {

    TreeNode prev;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // ***中序遍历位置***
        if (prev != null) {
            min = Math.min(min, (int) root.val - (int) prev.val);
        }
        prev = root;
        // ****************
        traverse(root.right);
    }
}
