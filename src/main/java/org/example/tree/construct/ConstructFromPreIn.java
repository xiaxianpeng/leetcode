package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;
import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * @author xianpeng.xia
 * on 2022/4/21 5:40 PM
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 */
public class ConstructFromPreIn {

    /**
     * 存储 inorder 中值对应的索引
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        // root 节点的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 构造树
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
            inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
            inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7}, inorder = new int[]{9, 3, 15, 20, 7};
        ConstructFromPreIn constructFromPreIn = new ConstructFromPreIn();
        TreeNode root = constructFromPreIn.buildTree(preorder, inorder);
        TreeUtil.printTree(root);
    }


}
