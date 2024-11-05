package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/3/29 8:07 PM
 * ⼆叉搜索树中的搜索
 *
 * 给定⼆叉搜索树（BST）的根节点和⼀个⽬标值。
 * 你需要在 BST 中找到节点值等于⽬标值的节点并返回，
 * 如 果节点不存在，则返回 NULL。
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if ((int) root.val > target) {
            return searchBST(root.left, target);
        } else if ((int) root.val < target) {
            return searchBST(root.left, target);
        } else {
            return root;
        }
    }
}
