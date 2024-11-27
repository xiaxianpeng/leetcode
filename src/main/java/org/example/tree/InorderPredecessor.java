package org.example.tree;

/**
 * 输入一个二叉树的节点，要求按中序遍历的顺序，返回输入节点的前一个节点。要求 O(1) 空间复杂度。
 * 示例
 * *
 * *        1
 * *      /  \
 * *    2     3
 * *  /  \    / \
 * * 4   5   6   7
 * *   /  \  /
 * *  10  9 8
 * 以上面的二叉树为例，
 * 输入节点 4，返回节点 null；
 * 输入节点 2，返回节点 4；
 * 输入节点 9，返回节点 5；
 * 输入节点 8，返回节点 1。
 * Created on 2024/11/27 20:24
 */
public class InorderPredecessor {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 找到给定节点的中序前驱节点
     *
     * @param node 二叉树中的一个节点
     * @return 中序前驱节点
     */
    public static TreeNode inorderPredecessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 情况1、
        // 左子树存在：如果给定节点有左子树，则前驱节点是其左子树中的最右下角的节点。
        if (node.left != null) {
            TreeNode predecessor = node.left;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            return predecessor;
        }

        // 情况2、
        // 左子树不存在：如果给定节点没有左子树，我们需要向上追溯父节点：
        //.如果当前节点是其父节点的右子节点，那么父节点就是前驱节点。
        //.如果当前节点是其父节点的左子节点，则继续向上寻找，直到找到一个节点是其父节点的右子节点，返回该父节点。
        TreeNode current = node;
        while (current.parent != null) {
            if (current == current.parent.right) {
                return current.parent;
            }
            current = current.parent;
        }
        // 如果没有找到满足条件的节点，则返回 null
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;

        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;

        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node7.parent = node3;

        node5.left = node10;
        node5.right = node9;
        node10.parent = node5;
        node9.parent = node5;

        node6.left = node8;
        node8.parent = node6;

        TreeNode result = inorderPredecessor(node4);
        System.out.println("Predecessor of node 4: " + (result != null ? result.val : "null")); // 输出 null

        result = inorderPredecessor(node2);
        System.out.println("Predecessor of node 2: " + (result != null ? result.val : "null")); // 输出 4

        result = inorderPredecessor(node9);
        System.out.println("Predecessor of node 9: " + (result != null ? result.val : "null")); // 输出 5

        result = inorderPredecessor(node8);
        System.out.println("Predecessor of node 8: " + (result != null ? result.val : "null")); // 输出 1
    }
}
