package org.example.tree.bst;

import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/3/29 10:00 AM
 * 删除BST节点
 *
 * 给定⼀个⼆叉搜索树的根节点 root 和⼀个值 key，
 * 删除⼆叉搜索树中的 key 对应的节点，并保证⼆叉搜索树的性质不变，
 * 返回删除后的⼆叉搜索树的根节点（有可能被更新）。
 */
public class DeleteNode {

    /**
     * 删除⽐插⼊和搜索都要复杂⼀些，分三种情况：
     * 情况 1：A 恰好是末端节点，两个⼦节点都为空，那么它可以当场去世了：
     * 情况 2：A 只有⼀个⾮空⼦节点，那么它要让这个孩⼦接替⾃⼰的位置：
     * 情况 3：A 有两个⼦节点，麻烦了，为了不破坏 BST 的性质，
     * A必须找到左⼦树中最⼤的那个节点或者右⼦树中最⼩的那个节点来接替⾃⼰，
     * 我的解法是⽤右⼦树中最⼩节点来替换：
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if ((int) root.val == (key)) {
            // 两个 if 把情况1 和 情况2 都处理了
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 处理情况3
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树的最小节点
            root.right = deleteNode(root.right, (int) minNode.val);
            // 用右子树的最小节点替代root节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if ((int) root.val < key) {
            deleteNode(root.left, key);
        } else {
            deleteNode(root.right, key);
        }

        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
