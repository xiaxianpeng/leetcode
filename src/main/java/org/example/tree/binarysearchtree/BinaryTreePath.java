package org.example.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，
 * 按 任意顺序 ，
 * 返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 * Created on 2025/1/9 21:38
 */
public class BinaryTreePath {

    /**
     * 使用dfs深度优先遍历构建从根节点到叶子节点的路径
     *
     * @param root 根节点
     * @return 根节点到所有叶子节点的路径列表
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        // 创建一个列表用于存储最终结果
        List<String> paths = new ArrayList<>();
        // 若根节点为空，则返回空列表
        if (root == null) {
            return paths;
        }
        // 使用dfs方法进行递归遍历
        dfs(root, String.valueOf(root.val), paths);
        return paths;
    }

    /**
     * dfs辅助方法
     *
     * @param node  当前遍历的节点
     * @param path  从根节点到当前节点的路径
     * @param paths 所有路径
     */
    private static void dfs(TreeNode node, String path, List<String> paths) {
        // 如果当前节点是叶子节点，将该路径加入到结果集
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        // 如果左子树存在，继续向左子树递归
        if (node.left != null) {
            // 递归调用时，将当前路径加上->和左子节点的值
            dfs(node.left, path + "->" + node.left.val, paths);
        }

        // 如果左子树存在，继续向左子树递归
        if (node.right != null) {
            // 递归调用时，将当前路径加上->和右子节点的值
            dfs(node.right, path + "->" + node.right.val, paths);
        }
    }


    public static void main(String[] args) {
        // [1,2,3,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        TreeUtil.printTree(root);

        System.out.println(binaryTreePaths(root));
    }
}
