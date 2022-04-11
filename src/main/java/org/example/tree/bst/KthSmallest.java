package org.example.tree.bst;


import java.util.PriorityQueue;
import java.util.Stack;
import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/4/11 10:10 PM
 *
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */
public class KthSmallest {

    /**
     * @param root root
     * @param k k
     *
     * 由于我们返回的是第 k小的数，因此我们可以构建一个容量为 k的大根堆。
     *
     * 根据大根堆的元素个数和当前节点与堆顶元素的关系来分情况讨论：
     *
     * 大根堆元素不足 k个：直接将当前节点值放入大根堆；
     * 大根堆元素为 k个，根据堆顶元素和当前节点值的大小关系进一步分情况讨论：
     * 如果当前节点值元素大于堆顶元素，说明当前节点值不可能在第 k小的范围内，直接丢弃；
     * 如果当前节点值元素小于堆顶元素，说明当前节点值可能在第 k小的范围内，先 poll 一个再 add 进去。
     * 树的遍历可以使用 DFS 或 BFS。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/gong-shui-san-xie-yi-ti-san-jie-pai-xu-y-8uah/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            if (queue.size() < k) {
                queue.add(node.val);
            } else if (queue.peek() > node.val) {
                queue.poll();
                queue.add(node.val);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return queue.peek();
    }

    /**
     * @param root root
     * @param k k
     *
     * 二叉搜索树的中序遍历是有序的，
     * 因此我们只需要对二叉搜索树执行中序遍历，
     * 并返回第 k 小的值即可。
     *
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/gong-shui-san-xie-yi-ti-san-jie-pai-xu-y-8uah/
     */
    public static int kthSmallestOfInorder(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;

        }
        // never
        return -1;
    }

    public static void main(String[] args) {

    }
}
