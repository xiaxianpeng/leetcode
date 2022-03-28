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
}
