package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * LCR 143. 子结构判断
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 示例 1：
 * 输入：tree1 = [1,7,5], tree2 = [6,1]
 * 输出：false
 * 解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
 * 示例 2：
 * 输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
 * 输出：true
 * 解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。
 * Created on 2024/12/23 18:11
 */
public class IsSubStructure {

    /**
     * 通过先序遍历+递归方式，判断tree2是否是tree1的子结构
     *
     * @param tree1 主树
     * @param tree2 待匹配子结构
     * @return tree2是否是tree1的子结构
     * 算法思路：
     * 1. 如果 tree2 为空，返回 false（按照题意，空树不作为子结构）。
     * 2. 如果 tree1 为空，无法匹配，返回 false。
     * 3. 检查当前 tree1 节点是否与 tree2 完全匹配。
     * 4. 如果不匹配，递归检查 tree1 的左子树和右子树。
     */
    public static boolean isSubStructure(TreeNode tree1, TreeNode tree2) {
        // tree2为空，空树不作为子结构，返回false
        if (tree2 == null) {
            return false;
        }
        // tree1为空，无法匹配
        if (tree1 == null) {
            return false;
        }
        // 先尝试在当前节点匹配,检查从tree1当前节点往下是否与tree2的结构和值完全一致
        // 如果不匹配，再去看看tree1.left和tree1.right有没有可能匹配
        return isSameStructure(tree1, tree2)
                || isSubStructure(tree1.left, tree2)
                || isSubStructure(tree1.right, tree2);
    }

    /**
     * 递归判断两子树的结构和值是否一致
     *
     * @param tree1 当前节点
     * @param tree2 当前节点
     * @return 二者子树是否匹配
     */
    private static boolean isSameStructure(TreeNode tree1, TreeNode tree2) {
        // 如果tree2先走到null，说明tree2全部匹配完，匹配成功
        if (tree2 == null) {
            return true;
        }

        // 如果tree2还有节点，但tree1空了，匹配失败
        // 或者两者值不相同，匹配失败
        if (tree1 == null || tree1.val != tree2.val) {
            return false;
        }

        // 递归比较左右子树
        return isSameStructure(tree1.left, tree2.left) && isSameStructure(tree1.right, tree2.right);
    }

    public static void main(String[] args) {

        /*
         *  tree1 = [1,7,5]，tree2 = [6,1]
         *   tree1       tree2
         *      1          6
         *     / \        /
         *    7   5      1
         */
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(7);
        tree1.right = new TreeNode(5);

        TreeNode tree2 = new TreeNode(6);
        tree2.left = new TreeNode(1);

        TreeUtil.printTree(tree1);
        TreeUtil.printTree(tree2);
        System.out.println("输出: " + isSubStructure(tree1, tree2));

        /*
         * tree1 = [3,6,7,1,8], tree2 = [6,1]
         *   tree1:           tree2:
         *       3               6
         *      / \             /
         *     6   7           1
         *    / \
         *   1   8
         */
        TreeNode tree3 = new TreeNode(3);
        tree3.left = new TreeNode(6);
        tree3.right = new TreeNode(7);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(8);

        TreeNode tree4 = new TreeNode(6);
        tree4.left = new TreeNode(1);

        TreeUtil.printTree(tree3);
        TreeUtil.printTree(tree4);
        System.out.println("输出: " + isSubStructure(tree3, tree4));
    }

}
