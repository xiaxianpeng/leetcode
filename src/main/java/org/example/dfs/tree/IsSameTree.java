package org.example.dfs.tree;

import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/3/28 7:54 PM
 * 判断是否是相同的树
 */
public class IsSameTree {

    /**
     * @param p 树p
     * @param q 树q
     * @return 是否是相同的树
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断相同节点是否相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 判断其他节点是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
