package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 8:45 PM
 * 给定⼀棵树的前序遍历结果 preorder 与中序遍历结果 inorder，请构造⼆叉树并返回其根节点。
 */
public class TreeBuild {

    /**
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return ⼆叉树
     * 给定⼀棵树的前序遍历结果 preorder 与中序遍历结果 inorder，请构造⼆叉树并返回其根节点。
     */
    TreeNode buildTree4preAndIn(int[] preorder, int[] inorder) {
        return build4preAndIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build4preAndIn(int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        // root节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal在中序遍历数组的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build4preAndIn(preorder, preStart + 1, preStart + leftSize,
            inorder, inStart, index - 1);
        root.right = build4preAndIn(preorder, preStart + leftSize + 1, preEnd,
            inorder, index + 1, inEnd);
        return root;
    }

    /**
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     * @return ⼆叉树
     * 给定⼀棵树的后序遍历结果 postorder 与中序遍历结果 inorder，
     * 请构造⼆叉树并返回其根节点。
     */
    TreeNode buildTree4inAndPost(int[] inorder, int[] postorder) {
        return build4InAndPost(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1);
    }

    TreeNode build4InAndPost(int[] inorder, int inStart, int inEnd,
        int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root节点为postorder数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal在中序遍历数组的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build4InAndPost(inorder, inStart, index - 1,
            postorder, postStart, postStart + leftSize - 1);
        root.right = build4InAndPost(inorder, index + 1, inEnd,
            postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    /**
     * @param nums 数组
     * @return 二叉树
     *
     * 给定⼀个不含重复元素的整数数组 nums，
     * ⼀个以此数组直接递归构建的最⼤⼆叉树定义如下：
     * 1、⼆叉树的根是数组 nums 中的最⼤元素。
     * 2、左⼦树是通过数组中最⼤元素左边的部分递归构造出的最⼤⼆叉树。
     * 3、右⼦树是通过数组中最⼤元素右边的部分递归构造出的最⼤⼆叉树。
     * 返回由给定数组nums构建的最⼤⼆叉树。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * @param nums 数组
     * @param lo 低位
     * @param hi 高位
     * @return 树
     * 将 nums[lo..hi] 构造成符合条件的树，返回根节点
     */

    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }
        // 找出数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 递归构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}
