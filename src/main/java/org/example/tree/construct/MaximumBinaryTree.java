package org.example.tree.construct;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * 示例 1：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * https://leetcode.cn/problems/maximum-binary-tree/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/16 18:27
 */
public class MaximumBinaryTree {

    /**
     * 1、核心思想：
     * .找到数组最大值，将其作为当前子树的根节点。
     * .最大值左边的数递归构建左子树，右边的数组递归构建右子树。
     * 2、递归边界：
     * .如果 left > right，表示子数组为空，返回 null。
     * 3、实现细节：
     * .遍历子数组[left,right]找到最大值及其索引。
     * .递归调用左边和右边的子数组分别构建左右子树。
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int left, int right) {
        // base case：数组为空
        if (left > right) {
            return null;
        }

        // 找到当前数组中的最大值及其索引
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // 创建根节点
        TreeNode root = new TreeNode(nums[maxIndex]);

        // 递归构建左右子树
        root.left = build(nums, left, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 6, 0, 5};
        int[] nums2 = {3, 2, 1};
        TreeNode root1 = constructMaximumBinaryTree(nums1);
        TreeUtil.printTree(root1);
        TreeNode root2 = constructMaximumBinaryTree(nums2);
        TreeUtil.printTree(root2);
    }
}
