package org.example.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/3/29 9:01 AM
 * 给你⼀个整数 n，请你⽣成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同⼆叉搜索树，可以 按任意顺序返回答案。
 */
public class GenerateBST {

    /**
     * @param n n
     * @return 所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同⼆叉搜索树，
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }
        // 1、穷举 root 节点的所有可能
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法BST
            List<TreeNode> leftTrees = build(lo, i - 1);
            List<TreeNode> rightTrees = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    // i作为根节点root的值
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
