package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
public class ConstructFromPostIn {

    /**
     * 存储 inorder 中值到索引的映射
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();

    /**
     *
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 构建中序数组值到索引的映射
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        // base case: 如果中序区间无效，返回 null
        if (inStart > inEnd) {
            return null;
        }

        // 根节点的值是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];

        // 在中序遍历数组中找到根节点的索引
        int index = valToIndex.get(rootVal);

        // 计算左子树的节点数
        int leftSize = index - inStart;

        // 构造根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造右子树
        root.right = build(inorder,
                index + 1, inEnd, // 中序右子树的范围，根节点的右边部分
                postorder,
                postStart + leftSize, postEnd - 1);// 后序右子树的范围,右子树的根节点是后序遍历中的倒数第二个元素

        // 递归构造左子树
        root.left = build(inorder,
                inStart, index - 1, // 中序左子树的范围，根节点的左边部分
                postorder,
                postStart, postStart + leftSize - 1); // 后序左子树的范围，左子树的根节点是后序遍历中的倒数第 leftSize 个元素

        // 返回构造好的子树根节点
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeUtil.printTree(new ConstructFromPostIn().buildTree(inorder, postorder));
    }
}
