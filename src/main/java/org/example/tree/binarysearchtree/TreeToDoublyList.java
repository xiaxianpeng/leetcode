package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 426.将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，
 * 第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 特别地，我们希望可以 就地 完成转换操作。
 * 当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
 * 还需要返回链表中最小元素的指针。
 * 示例 1：
 * 输入：root = [4,2,5,1,3]
 * 输出：[1,2,3,4,5]
 * 解释：下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[1,2,3]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 解释：输入是空树，所以输出也是空链表。
 * 示例 4：
 * 输入：root = [1]
 * 输出：[1]
 * Created on 2024/12/23 19:16
 */
public class TreeToDoublyList {

    private TreeNode prev = null;
    private TreeNode head = null;

    /**
     * 通过中序遍历的递归方式，将二叉搜索树就地转化为已排序的双向循环链表¬
     *
     * @param root 二叉搜索树的根节点
     * @return 已排序的双向链表的最小节点
     * 算法思路：
     * 1、使用中序遍历访问节点，确保节点按升序排列
     * 2、在遍历过程中，维护前一个访问的节点prev，并将当前节点与prev节点互相连接
     * 3、最后，将头节点(最小节点)与尾节点(最后访问的节点)连接，形成循环链表
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 中序遍历并连接节点
        inorderTraversal(root);
        // 连接头尾，形成循环链表
        head.left = prev;
        prev.right = head;

        return head;
    }

    /**
     * 中序遍历辅助方法，用来连接双向链表节点
     *
     * @param node 当前访问的节点
     */
    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 递归遍历左子树
        inorderTraversal(node.left);

        // 处理当前节点
        if (prev != null) {
            // 连接当前节点与前驱节点
            prev.right = node;
            node.left = prev;
        } else {
            // 当前节点是最左节点，也是链表的头结点
            head = node;
        }
        // 更新前驱节点为当前节点
        prev = node;

        // 递归遍历右子树
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(4);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(3);

        TreeUtil.printTree(tree1);
        TreeNode head = new TreeToDoublyList().treeToDoublyList(tree1);
        printDoublyCircularList(head, 5);
    }

    public static void printDoublyCircularList(TreeNode head, int limit) {
        if (head == null) {
            System.out.println("转换后的链表为空。");
            return;
        }
        System.out.print("转换后的双向循环链表: ");
        TreeNode current = head;
        int count = 0;
        do {
            System.out.print(current.val + " ");
            current = current.right;
            count++;
        } while (current != head && count < limit);
        System.out.println();
    }
}
