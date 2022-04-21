package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;
import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * @author xianpeng.xia
 * on 2022/4/21 4:58 PM
 *
 * * 通过后序和前序遍历结果构造二叉树
 * * https://labuladong.github.io/algo/2/19/35/
 * *
 * * 1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
 * *
 * * 2、然后把前序遍历结果的第二个元素作为左子树的根节点的值。
 * *
 * * 3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。
 */
public class ConstructFromPrePost {

    /**
     * // 存储 postorder 中值到索引的映射
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
            postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {

        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root节点对应的值就是前序遍历的第一个值
        int rootVal = preorder[preStart];
        // root.left的值是前序遍历的第二个元素
        // 确定 preorder 和 postorder 左右子树的区间
        int leftRootVal = preorder[preStart + 1];
        // root.left在后续遍历的索引
        int index = valToIndex.get(leftRootVal);
        //  左子树的元素个数
        int leftSize = index - postStart + 1;

        // 构造root节点
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
            postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
            postorder, index + 1, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 3}, postorder = new int[]{3, 2, 1};
        ConstructFromPrePost constructFromPrePost = new ConstructFromPrePost();
        TreeNode root = constructFromPrePost.constructFromPrePost(preorder, postorder);

        TreeUtil.print(root);
    }

}
