package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */
public class SortedArrayToBST {


    /**
     * 将升序数组转换为高度平衡的二叉搜索树。
     * 递归地选择中间元素作为根节点，以保持平衡。
     *
     * @param nums 升序整数数组
     * @return 高度平衡的二叉搜索树根节点
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 辅助方法：递归构建平衡二叉搜索树
     *
     * @param nums 有序整数数组
     * @param low  左边界
     * @param high 右边界
     * @return 当前子树的根节点
     */
    private static TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;// 子数组为空时，返回 null
        }

        // 选择中间元素作为根节点
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        System.out.println("Creating node with value: " + nums[mid] + ", left: " + low + ", right: " + high);

        // 递归构建左子树和右子树
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);

        // 返回当前子树的根节点
        return root;
    }

    public static void main(String[] args) {
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = sortedArrayToBST(nums1);
        System.out.println("BST from sorted array 1: ");
        TreeUtil.printTree(root1);

        int[] nums2 = {1, 3};
        TreeNode root2 = sortedArrayToBST(nums2);
        System.out.println("BST from sorted array 2: ");
        TreeUtil.printTree(root2);
    }
}
