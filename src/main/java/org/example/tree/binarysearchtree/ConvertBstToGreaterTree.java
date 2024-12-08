package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * 示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * Created on 2024/11/17 00:00
 */
public class ConvertBstToGreaterTree {

    private int sum;

    /**
     * 问题需求
     * 我们需要将每个节点的值更新为包括大于或等于当前节点的所有节点值的累加和。
     * 这意味着对于每个节点，我们需要提前知道所有比它大的节点的值总和。
     * *
     * 反向中序遍历的优势
     * 通过反向中序遍历（右-根-左）树：
     * *
     * 顺序满足需求: 反向中序遍历会从最大值开始遍历到最小值，因此可以在遍历过程中自然地累加值。
     * 逐步累加: 当我们访问一个节点时，已经累加了所有比它大的节点的值到一个全局变量 sum 中，
     * 因此可以直接将这个值加到当前节点的值上。
     * 简单实现: 通过递归或迭代方式实现反向中序遍历，使得累加过程简洁且高效。
     */
    public TreeNode convertBst(TreeNode root) {
        inOrderTraverse(root);
        return root;
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 递归遍历右子树
        inOrderTraverse(node.right);

        // ******反中序遍历位置******//
        // 更新当前节点的值和累加和
        sum += node.val;
        node.val = sum;
        // **********************//

        // 递归遍历右子树
        inOrderTraverse(node.left);
    }

    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.left.right.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        root1.right.right.right = new TreeNode(8);
        TreeUtil.printTree(root1);
        TreeUtil.printTree(new ConvertBstToGreaterTree().convertBst(root1));
        // 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

        // 示例 2
        TreeNode root2 = new TreeNode(0);
        root2.right = new TreeNode(1);
        TreeUtil.printTree(root2);
        TreeUtil.printTree(new ConvertBstToGreaterTree().convertBst(root2));
        // 输出：[1,null,1]

        // 示例 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(2);
        TreeUtil.printTree(root3);
        TreeUtil.printTree(new ConvertBstToGreaterTree().convertBst(root3));
        // 输出：[3,3,2]

        // 示例 4
        TreeNode root4 = new TreeNode(3);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(4);
        root4.left.left = new TreeNode(1);
        TreeUtil.printTree(root4);
        TreeUtil.printTree(new ConvertBstToGreaterTree().convertBst(root4));
        // 输出：[7,9,4,10]
    }
}
