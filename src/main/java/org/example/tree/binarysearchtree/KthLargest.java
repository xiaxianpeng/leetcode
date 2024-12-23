package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * LCR 174. 寻找二叉搜索树中的目标节点
 * 某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。
 * 示例 1：
 * 输入：root = [7, 3, 9, 1, 5], cnt = 2
 * *       7
 * *      / \
 * *     3   9
 * *    / \
 * 8   1   5
 * 输出：7
 * 示例 2：
 * 输入: root = [10, 5, 15, 2, 7, null, 20, 1, null, 6, 8], cnt = 4
 * *        10
 * *       /  \
 * *      5    15
 * *     / \     \
 * *    2   7     20
 * *   /   / \
 * *  1   6   8
 * 输出: 8
 * 示例 3：
 * 输入: root = []
 * 输出: -1
 * 解释：输入是空树，所以没有员工编号可返回。
 * 示例 4：
 * 输入: root = [1], cnt = 1
 * 输出: 1
 * Created on 2024/12/23 20:56
 */
public class KthLargest {
    private int count = 0;//计数器，用来记录当前访问的节点数量
    private int result = -1;//结果变量，存储第cnt大的节点值

    /**
     * 通过逆中序遍历(右->根->左)的递归方式，找到二叉搜索树中第cnt大的节点值
     *
     * @param root 二叉树的根节点
     * @param cnt  目标排名
     * @return 第cnt大的值
     * 算法思想：
     * 1、采用逆中序遍历，确保节点按降序排列
     * 2、在遍历过程中，维护一个计数器，每访问一个节点，计数器+1
     * 3、当计数器等于cnt时，记录当前节点的值并终止遍历
     */
    public int findKthLargest(TreeNode root, int cnt) {
        reverseInorderTraversal(root, cnt);
        return result;
    }

    /**
     * 逆中序遍历
     *
     * @param node 当前访问的节点
     * @param cnt  cnt
     */
    private void reverseInorderTraversal(TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        // 递归遍历右子树
        reverseInorderTraversal(node.right, cnt);

        // 访问当前节点
        count++;
        if (count == cnt) {
            result = node.val;
            return;
        }

        // 递归遍历左子树
        reverseInorderTraversal(node.left, cnt);
    }

    public static void main(String[] args) {
        /*
             7
            / \
           3   9
          / \
         1   5
        */
        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(5);
        int cnt1 = 2;
        TreeUtil.printTree(root1);
        System.out.println(new KthLargest().findKthLargest(root1, cnt1));

        /*
                10
               /  \
              5    15
             / \     \
            2   7     20
           /   / \
          1   6   8
        */
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(7);
        root2.right.right = new TreeNode(20);
        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(8);
        TreeUtil.printTree(root2);
        int cnt2 = 4;
        System.out.println(new KthLargest().findKthLargest(root2, cnt2));

        /*
            输入: root = []
            输出: []
        */
        TreeNode root3 = null;
        int cnt3 = 1;
        System.out.println(new KthLargest().findKthLargest(root3, cnt3));

        /*
            输入: root = [1]
            输出: [1]
        */
        TreeNode root4 = new TreeNode(1);
        int cnt4 = 1;
        System.out.println(new KthLargest().findKthLargest(root4, cnt4));
    }
}
