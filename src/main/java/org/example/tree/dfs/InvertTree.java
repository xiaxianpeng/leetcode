package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class InvertTree {

    // 方法1：递归地翻转二叉树
    // 思路：对于每个节点，交换其左右子树，并递归地对子树进行同样的操作。
    public static TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        //System.out.println("Inverting Node with value: " + node.val);

        // 递归地翻转左右子树
        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);

        // 交换左右子树
        node.left = right;
        node.right = left;

        // 返回当前节点
        return node;
    }

    // 方法2：递归地翻转二叉树
    // 思路：直接在当前节点上交换左右子树。
    public static TreeNode invertTree2(TreeNode node) {
        if (node == null) {
            return null;// 终止条件：当节点为空时，返回null
        }
        // 暂存左子节点
        TreeNode left = node.left;
        // 递归翻转右子树，并将其设置为当前节点的左子节点
        node.left = invertTree2(node.right);
        // 递归翻转左子树，并将其设置为当前节点的右子节点
        node.right = invertTree2(left);
        // 返回当前节点
        return node;
    }

    public static void main(String[] args) {

        // 示例 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.println("Original Tree 1: ");
        TreeUtil.printTree(root1); // 使用工具类打印原始树
        TreeNode invertedRoot1 = invertTree(root1);
        System.out.println("Inverted Tree 1: ");
        TreeUtil.printTree(invertedRoot1); // 打印翻转后的树

        // 示例 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println("Original Tree 2: ");
        TreeUtil.printTree(root2);
        TreeNode invertedRoot2 = invertTree(root2);
        System.out.println("Inverted Tree 2: ");
        TreeUtil.printTree(invertedRoot2);

        // 示例 3
        TreeNode root3 = null;

        System.out.println("Original Tree 3: ");
        TreeUtil.printTree(root3);
        TreeNode invertedRoot3 = invertTree(root3);
        System.out.println("Inverted Tree 3: ");
        TreeUtil.printTree(invertedRoot3);


    }
}
