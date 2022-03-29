package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/29 9:41 AM
 *
 * 给你⼀个⼆叉树的根节点 root，判断其是否是⼀个有效的⼆叉搜索树。
 */
public class IsValidBST<Integer> {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * @param root root
     * @param min 最小值
     * @param max 最大值
     * @return 是否是bst
     * 限定以 root 为根的⼦树节点必须满⾜ max.val > root.val > min.val
     */
    private static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return false;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && (int) root.val <= (int) min.val) {
            return false;
        }
        if (max != null && (int) root.val >= (int) max.val) {
            return false;
        }
        // 限定左⼦树的最⼤值是 root.val，右⼦树的最⼩值是 root.val
        return isValidBST(root.left, min, root)
            && isValidBST(root.right, root, max);
    }
}
