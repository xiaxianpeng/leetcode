package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 示例 1:
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * 输入: root = [], key = 0
 * 输出: []
 * 提示:
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 */
public class DeleteNode {


    /**
     * 删除二叉搜索树的指定节点，并保持树的性质不变
     *
     * @param node node
     * @param key  key
     * @return root
     * 算法思路：
     * 1、在BST中查找要删除的节点
     * 2、如果节点不存在，直接返回原树
     * 3、如果节点存在
     * a、节点为叶子节点，直接删除
     * b、节点只有一个子节点，删除子节点并用子节点替代
     * c、节点有两个子节点，找到右子树的最小节点替代当前节点，然后删除替代节点
     */
    public static TreeNode deleteNode(TreeNode node, int key) {

        // 如果当前节点为空，直接返回null
        if (node == null) {
            System.out.println("节点不存在");
            return null;
        }

        // 如果key小于当前节点值，递归删除左子树中的节点
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
        }
        // 如果key大于当前节点值，递归删除右子树中的节点
        else if (key > node.val) {
            node.right = deleteNode(node.right, key);
        }
        // 找到要删除的节点
        else {
            // 节点只有一个子节点或没有子节点
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // 节点有2个子节点，找到右子树的最小值节点
            TreeNode rightMinNode = getMin(node.right);
            // 用最小节点的值替代当前节点的值
            node.val = rightMinNode.val;
            // 删除右子树中的最小节点
            node.right = deleteNode(node.right, rightMinNode.val);
        }

        return node;
    }

    /**
     * 查找二叉树中的最小值节点
     *
     * @param node node
     * @return minNode
     */
    private static TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeUtil.printTree(root);
        int key = 3;
        System.out.println("删除节点值: " + key);
        TreeNode updatedRoot = deleteNode(root, key);
        TreeUtil.printTree(updatedRoot);
    }
}
