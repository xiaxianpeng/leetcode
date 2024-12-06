package org.example.bfs.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，
 * 你的函数应该填充它的每个 next 指针，
 * 以指向其下一个右侧节点，如图 B 所示。
 * 序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 * Created on 2024/12/6 20:25
 */
public class Connect2 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * 使用层序遍历连接每个节点的 next 指针指向其右侧节点。
     *
     * @param root 二叉树的根节点
     * @return 修改后的二叉树根节点
     */
    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;// 如果树为空，直接返回 null
        }

        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);// 初始化当前层节点列表

        // 遍历每一层
        while (!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();// 下一层的节点列表
            for (int i = 0; i < currentLevel.size(); i++) {
                TreeNode currentNode = currentLevel.get(i);

                // 连接同一层的相邻节点
                if (i > 0) {
                    currentLevel.get(i - 1).next = currentNode;
                }

                // 添加下一层的子节点
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
            }
            currentLevel = nextLevel;// 进入下一层
        }

        return root;// 返回连接后的根节点
    }

    public static void main(String[] args) {
        // 二叉树：[1,2,3,4,5,null,7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        connect(root);

        System.out.println("节点 1 的 next: " + getNextVal(root));//null
        System.out.println("节点 2 的 next: " + getNextVal(root.left));//3
        System.out.println("节点 3 的 next: " + getNextVal(root.right));//null
        System.out.println("节点 4 的 next: " + getNextVal(root.left.left));//5
        System.out.println("节点 5 的 next: " + getNextVal(root.left.right));//7
        System.out.println("节点 7 的 next: " + getNextVal(root.right.right));//null
    }

    /**
     * 获取节点的 next 指针值。
     *
     * @param node 目标节点
     * @return next 节点的值或 "null"
     */
    private static String getNextVal(TreeNode node) {
        return (node.next == null) ? "null" : String.valueOf(node.next.val);
    }
}
