package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/4/9 11:27 PM
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class IsSymmetric {

    /**
     * @param root root
     *
     * 递归结束条件：
     *
     * * 都为空指针则返回 true
     * * 只有一个为空则返回 false
     * 递归过程：
     *
     * 判断两个指针当前节点值是否相等
     * * 判断 A 的左子树与 B 的右子树是否对称
     * * 判断 A 的右子树与 B 的左子树是否对称
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/hua-jie-suan-fa-101-dui-cheng-er-cha-shu-by-guanpe/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return ((int) t1.val == (int) t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
