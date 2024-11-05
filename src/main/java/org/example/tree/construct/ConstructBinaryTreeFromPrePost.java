package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;

import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/4/17 10:27 PM
 *
 * 通过后序和前序遍历结果构造二叉树
 * https://labuladong.github.io/algo/2/19/35/
 *
 * 1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
 *
 * 2、然后把前序遍历结果的第二个元素作为左子树的根节点的值。
 *
 * 3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。
 */
public class ConstructBinaryTreeFromPrePost {

    /**
     * // 存储 postorder 中值到索引的映射
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        //
        return build(preorder, 0, preorder.length - 1,
            postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
        int[] postorder, int postStart, int postEnd) {

        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root节点对应的值就是前序遍历的第一个元素
        int rootVal = preorder[preStart];
        // root.left的值是前序遍历的第二个元素
        // 通过前序和后续遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的区间
        int leftRootVal = preorder[preStart + 1];
        // leftRootVal 在后续遍数组中的索引
        int index = valToIndex.get(leftRootVal);
        // 左子树的元素个数
        int leftSize = index - postStart + 1;

        // 构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize
            , postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
            postorder, index + 1, postEnd - 1);
        return root;
    }


}
