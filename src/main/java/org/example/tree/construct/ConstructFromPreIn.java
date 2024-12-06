package org.example.tree.construct;

import java.util.HashMap;
import java.util.Map;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 */
public class ConstructFromPreIn {

    /**
     * 存储 inorder 中值对应的索引
     */
    Map<Integer, Integer> valToIndex = new HashMap<>();


    /**
     * 方法：递归构造二叉树
     * 思路：利用前序遍历确定根节点，中序遍历划分左右子树，递归构造整个树。
     *
     * @param preorder 二叉树的前序遍历结果
     * @param inorder  二叉树的中序遍历结果
     * @return 构造的二叉树的根节点
     * 算法思路：
     * 1. 前序遍历的特点：
     * - 第一个节点是当前子树的根节点。
     * 2. 中序遍历的特点：
     * - 根节点的左边是左子树的所有节点，右边是右子树的所有节点。
     * 3. 算法步骤：
     * - 在前序数组中找到当前子树的根节点（第一个元素）。
     * - 在中序数组中找到根节点的位置，划分出左子树和右子树的节点范围。
     * - 根据划分结果，递归构建左右子树。
     * 4. 加速优化：
     * - 使用哈希表存储中序数组中每个值对应的索引，以便快速查找根节点位置。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建哈希表，记录中序遍历值 -> 索引的映射
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        // 调用递归函数构建二叉树
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 递归构建二叉树的辅助函数
     *
     * @param preorder 前序遍历数组
     * @param preStart 前序遍历当前子树的起始索引
     * @param preEnd   前序遍历当前子树的结束索引
     * @param inorder  中序遍历数组
     * @param inStart  中序遍历当前子树的起始索引
     * @param inEnd    中序遍历当前子树的结束索引
     * @return 当前子树的根节点
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        // base case：如果索引范围无效，说明子树为空
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个元素是当前子树的根节点
        int rootVal = preorder[preStart];
        // 在中序遍历中找到根节点的索引位置，以划分左右子树
        int index = valToIndex.get(rootVal);
        // 计算左子树的节点数量
        int leftSize = index - inStart;

        // 构造根节点
        TreeNode root = new TreeNode(rootVal);
        System.out.println("Constructing node with value: " + rootVal);
        System.out.println("Left subtree in inorder: " + inStart + " to " + (index - 1));
        System.out.println("Right subtree in inorder: " + (index + 1) + " to " + inEnd);

        // 递归构造左子树
        root.left = build(preorder,
                preStart + 1,          // 左子树的起始索引：跳过根节点
                preStart + leftSize,          // 左子树的结束索引：根 + 左子树大小
                inorder,
                inStart,                      // 中序左子树起始索引
                index - 1);                  //  中序左子树结束索引：根索引 - 1

        // 递归构造右子树
        root.right = build(preorder,
                preStart + leftSize + 1, // 右子树的起始索引：跳过左子树
                preEnd,                         // 前序右子树结束索引
                inorder,
                index + 1,               // 中序右子树起始索引：根索引 + 1
                inEnd);                        // 中序右子树结束索引

        return root; // 返回当前子树的根节点
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeUtil.printTree(new ConstructFromPreIn().buildTree(preorder, inorder));

        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeUtil.printTree(new ConstructFromPreIn().buildTree(preorder2, inorder2));
    }


}
