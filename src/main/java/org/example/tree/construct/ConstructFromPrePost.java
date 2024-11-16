package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 给定两个整数数组，preorder 和 postorder ，
 * 其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，
 * postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * 示例 1：
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 */
public class ConstructFromPrePost {

    /**
     * // 存储 postorder 中值到索引的映射
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 构建后序遍历的值到索引的映射，方便快速查找
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        // 从根节点开始递归构建二叉树
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /**
     * 算法思路：
     * 1. 前序遍历的第一个节点是当前子树的根节点。
     * 2. 后序遍历的最后一个节点是当前子树的根节点。
     * 3. 前序遍历中根节点的右子树的根节点是前序的第二个节点。
     * 4. 通过根节点的左子树根节点值，可以在后序遍历中找到左子树节点的范围，进而递归构建左右子树。
     * 5. 使用哈希表存储后序遍历节点到索引的映射，以便快速查找根节点的左右子树区间。
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        // base case: 如果当前区间无效，返回 null
        if (preStart > preEnd) {
            return null;
        }

        // 如果该节点是叶子节点（没有左右子树），直接返回根节点
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // 根节点的值是前序遍历的第一个元素
        int rootVal = preorder[preStart];

        // 获取左子树根节点的值（前序遍历的第二个元素）
        int leftRootVal = preorder[preStart + 1];

        // 在后序遍历中找到左子树根节点的位置
        int index = valToIndex.get(leftRootVal);

        // 计算左子树的节点数 ; [postStart,index]
        int leftSize = index - postStart + 1;

        // 构造root节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构建左子树
        root.left = build(preorder,
                preStart + 1,  // 左子树的起始索引：跳过当前根节点
                preStart + leftSize,  // 左子树的结束索引：根节点 + 左子树大小
                postorder,            // 后序左子树起始索引
                postStart, index);    // 后序左子树结束索引：左子树根节点的后序索引

        // 递归构建右子树
        root.right = build(preorder,
                preStart + leftSize + 1, // 右子树的起始索引：跳过左子树部分
                preEnd,                         // 前序右子树的结束索引：直到当前区间的结束
                postorder,
                index + 1,              // 后序右子树的起始索引：左子树根节点后面的位置
                postEnd - 1);                   // 后序右子树的结束索引：当前区间的倒数第二个节点

        // 返回当前节点，已连接左右子树
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeUtil.printTree(new ConstructFromPrePost().constructFromPrePost(preorder, postorder));
    }

}
