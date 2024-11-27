package org.example.tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * *        1
 * *      /  \
 * *    2     3
 * *  /  \    / \
 * * 4   5   6   7
 * *   /  \  /
 * *  10  9 8
 * * 以上面的二叉树为例，
 * * 输入节点 4，返回节点 1；
 * * 输入节点 2，返回节点 10；
 * * 输入节点 9，返回节点 1；
 * * 输入节点 8，返回节点 6。
 * Created on 2024/11/27 21:10
 */
public class InorderSuccessor {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode inorderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 情况1：节点有右子树，后继为右子树的最左节点
        if (node.right != null) {
            TreeNode successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }

        // 情况2：没有右子树，向上查找
        TreeNode current = node;
        while (current.parent != null) {
            // 如果当前节点是其父节点的左子节点，则父节点为后继
            if (current == current.parent.left) {
                return current.parent;
            }
            current = current.parent;
        }

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

        TreeNode result = inorderSuccessor(node4);
        System.out.println("Successor of node 4: " + (result != null ? result.val : "null")); // 输出 2

        result = inorderSuccessor(node2);
        System.out.println("Successor of node 2: " + (result != null ? result.val : "null")); // 输出 10

        result = inorderSuccessor(node9);
        System.out.println("Successor of node 9: " + (result != null ? result.val : "null")); // 输出 1

        result = inorderSuccessor(node8);
        System.out.println("Successor of node 8: " + (result != null ? result.val : "null")); // 输出 6
    }
}
