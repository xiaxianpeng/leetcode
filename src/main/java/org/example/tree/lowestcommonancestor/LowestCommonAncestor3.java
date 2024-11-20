package org.example.tree.lowestcommonancestor;

import java.util.HashSet;
import java.util.Set;

/**
 * 1650. 二叉树的最近公共祖先 III
 * 给定一棵二叉树中的两个节点 p 和 q，返回它们的最近公共祖先节点（LCA）。
 * 每个节点都包含其父节点的引用（指针）。Node 的定义如下：
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node parent;
 * }
 * 根据维基百科中对最近公共祖先节点的定义：“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点（我们允许一个节点为自身的一个后代节点）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和 1 的最近公共祖先是 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和 4 的最近公共祖先是 5，根据定义，一个节点可以是自身的最近公共祖先。
 * 示例 3:
 * 输入: root = [1,2], p = 1, q = 2
 * 输出: 1
 * 提示:
 * 树中节点个数的范围是 [2, 105]。
 * -109 <= Node.val <= 109
 * 所有的 Node.val 都是互不相同的。
 * p != q
 * p 和 q 存在于树中。
 * Created on 2024/11/13 23:26
 */
public class LowestCommonAncestor3 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * 算法思路如下：
     * 1、从节点 p 开始，遍历其所有先祖节点（包括它自己），并将它们存储在一个集合中。
     * 2、然后从节点 q 开始向上遍历其先祖节点（包括它自己），检查每个节点是否已存在于 p 的祖先节点集合中。
     * 3、第一个出现在 p 的祖先节点集合中的 q 的祖先节点就是两个节点的最近公共祖先。
     */
    public static Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> ancestors = new HashSet<>();
        // 记录p的所有祖先
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }
        // 检查q或其祖先是否是p的祖先
        while (q != null) {
            if (ancestors.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        // 如果不存在公共祖先（理论上不可能，因为最后 root 节点肯定共享）
        return null;
    }

    public static void main(String[] args) {
        // 手动构建示例二叉树
        Node root = new Node();
        root.val = 3;

        Node node5 = new Node();
        node5.val = 5;
        node5.parent = root;

        Node node1 = new Node();
        node1.val = 1;
        node1.parent = root;

        Node node6 = new Node();
        node6.val = 6;
        node6.parent = node5;

        Node node2 = new Node();
        node2.val = 2;
        node2.parent = node5;

        Node node0 = new Node();
        node0.val = 0;
        node0.parent = node1;

        Node node8 = new Node();
        node8.val = 8;
        node8.parent = node1;

        Node node7 = new Node();
        node7.val = 7;
        node7.parent = node2;

        Node node4 = new Node();
        node4.val = 4;
        node4.parent = node2;

        // 设置左右子节点
        root.left = node5;
        root.right = node1;

        node5.left = node6;
        node5.right = node2;

        node1.left = node0;
        node1.right = node8;

        node2.left = node7;
        node2.right = node4;


        // 示例 1: 查找节点 5 和节点 1 的 LCA
        Node lca1 = lowestCommonAncestor(node5, node1);
        System.out.println("示例 1: 节点 5 和节点 1 的最近公共祖先是节点 " + lca1.val); // 应输出 3

        // 示例 2: 查找节点 5 和节点 4 的 LCA
        Node lca2 = lowestCommonAncestor(node5, node4);
        System.out.println("示例 2: 节点 5 和节点 4 的最近公共祖先是节点 " + lca2.val); // 应输出 5

        // 示例 3: 查找节点 1 和节点 2 的 LCA
        Node lca3 = lowestCommonAncestor(node1, node2);
        System.out.println("示例 3: 节点 1 和节点 2 的最近公共祖先是节点 " + lca3.val); // 应输出 3
    }
}
