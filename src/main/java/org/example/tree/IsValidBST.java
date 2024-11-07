package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/29 9:41 AM
 * <p>
 * 给你⼀个⼆叉树的根节点 root，判断其是否是⼀个有效的⼆叉搜索树。
 */
public class IsValidBST<Integer> {

    /**
     * 是否是二叉搜索树
     *
     * @param root root
     * @return 是否是二叉搜索树
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * @param node 当前正在检查的节点。
     * @param min  当前子树允许的最小值节点，如果没有最小值限制则为 null。
     * @param max  当前子树允许的最大值节点，如果没有最大值限制则为 null。
     * @return 是否是bst
     * 限定以 root 为根的⼦树节点必须满⾜ max.val > root.val > min.val
     */
    private static boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        // 基准情况：空树是有效的二叉搜索树
        if (node == null) {
            return true;
        }
        // 每个节点的左子树只包含小于该节点的值，
        if (min != null && node.val <= min.val) {
            return false;
        }
        // 每个节点的右子树只包含大于该节点的值。
        if (max != null && node.val >= max.val) {
            return false;
        }
        // 递归检查左右子树，并更新最小/最大值
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }

    /**
     * @param root root
     * 中序遍历，判断当前节点是都大于中序遍历的前一个节点
     */
    static long pre = Long.MIN_VALUE;

    public static boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValid(root.left)) {
            return false;
        }
        //******中序遍历位置******
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if ((int) root.val <= pre) {
            return false;
        }
        //**********************
        pre = (int) root.val;
        // 访问右子树
        return isValid(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));

        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);
        System.out.println(isValidBST(invalidRoot));
    }
}
