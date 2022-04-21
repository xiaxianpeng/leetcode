package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;
import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * @author xianpeng.xia
 * on 2022/4/21 6:28 PM
 *
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
public class ConstructFromPostIn {

    /**
     * 存储 inorder 中值到索引的映射
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
        int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
            postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd,
            postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7}, postorder = new int[]{9, 15, 7, 20, 3};
        ConstructFromPostIn constructFromPostIn = new ConstructFromPostIn();
        TreeNode root = constructFromPostIn.buildTree(inorder, postorder);
        TreeUtil.print(root);
    }
}
