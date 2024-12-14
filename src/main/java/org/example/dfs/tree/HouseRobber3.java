package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 示例 1:
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * Created on 2024/12/14 14:49
 */
public class HouseRobber3 {
    /**
     * 使用后序遍历的动态规划思想，对每个节点返回两个值
     * 1、偷该节点时所能获取的最大金额
     * 2、不偷该节点时所能获取的最大金额
     *
     * @param root 二叉树的根节点
     * @return 不触发报警的最高可盗金额
     * 算法核心思想：
     * 对于每个节点，有两种情况：
     * 1、偷当前节点（则不能偷左右子节点）
     * 2、不偷当前节点（则可以偷左右子节点）
     */
    public static int rob(TreeNode root) {
        // 获取该树的状态收益
        int[] res = robSub(root);
        // 返回不偷和偷两种状态中较大的结果
        return Math.max(res[0], res[1]);
    }

    /**
     * 递归函数：对某节点返回偷和不偷两个状态的结果
     * res[0] -> 不偷该节点时所能获得的最大金额
     * res[1] -> 偷该节点时所能获得的最大金额
     * 对每个节点计算偷与不偷状态下的最大收益，通过自底向上动态规划求解最终最大金额。
     *
     * @param node 二叉树的节点
     * @return 对某节点返回偷和不偷两个状态的结果
     */
    private static int[] robSub(TreeNode node) {
        // 空节点收益为0
        if (node == null) {
            return new int[]{0, 0};
        }
        // 左子树状态收益
        int[] left = robSub(node.left);
        // 右子树状态收益
        int[] right = robSub(node.right);
        // 不偷当前节点：左右子树可自由选择偷或不偷取最大值
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点：左右子树都不能偷，只能使用不偷子节点的收益
        int rob = node.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }

    public static void main(String[] args) {
        // [3,4,5,1,3,null,1]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        TreeUtil.printTree(root);
        System.out.println("Max amount: " + rob(root)); // 输出: 9
    }
}
