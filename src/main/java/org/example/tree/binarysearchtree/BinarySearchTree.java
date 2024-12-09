package org.example.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return this.data + "";
        }
    }

    private Node root;

    /**
     * 我们先取根节点，如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；
     * 如果要查找的数据比根节点的值大，那就在右子树中递归查找。
     */
    public Node find(int data) {
        Node p = root;
        // 我们先取根节点，如果它等于我们要查找的数据，那就返回
        while (p != null) {
            if (data < p.data) {
                // 如果要查找的数据比根节点的值小，那就在左子树中递归查找；
                p = p.left;
            } else if (data > p.data) {
                // 如果要查找的数据比根节点的值大，那就在右子树中递归查找。
                p = p.right;
            } else {
                // 如果它等于我们要查找的数据，那就返回
                return p;
            }
        }
        return null;
    }

    /**
     * 插入的数据一般都是在叶子节点上，所以我们只需要从根节点开始，依次比较要插入的数据和节点的大小关系。
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；
     * 如果不为空，就再递归遍历右子树，查找插入位置。
     * 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
     * 如果不为空，就再递归遍历左子树，查找插入位置。
     */
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        // 新插入的数据一般都是在叶子节点上，
        // 所以我们只需要从根节点开始，依次比较要插入的数据和节点的大小关系。
        Node p = root;
        while (p != null) {
            if (data > p.data) {
                // 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；
                // 如果不为空，就再递归遍历右子树，查找插入位置。
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                // data < p.data
                // 如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
                // 如果不为空，就再递归遍历左子树，查找插入位置。
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 从二叉查找树（Binary Search Tree, BST）中删除指定值的节点。
     * 删除操作根据要删除节点的子节点数量分为三种情况：
     * 节点没有子节点（叶子节点）：直接移除节点。
     * 节点只有一个子节点：用子节点替换被删除节点。
     * 节点有两个子节点：找到右子树中的最小节点（中序后继），
     * 用其值替换被删除节点的值，然后删除该最小节点。
     *
     * @param data 要删除的节点的值。
     */
    public void delete(int data) {
        // 1、初始化指针
        // p 指向要删除的节点，从根节点开始查找
        Node p = root;
        // pp 保存 p 的父节点，初始为 null (因为 p 初始为 root)
        Node pp = null;

        // 2、在 BST 中查找值为 data 的节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        // 如果没有找到，直接返回
        if (p == null) {
            // 没有找到要删除的节点
            return;
        }

        // 3、如果 p 有两个子节点
        if (p.left != null && p.right != null) {
            // 3.1 找到 p 的右子树的最小节点 minP 及其父节点 minPP
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 3.2 用 minP 的值替换 p 的值
            p.data = minP.data;
            // 因为 minP 是右子树的最小节点，它最多只有一个右子节点，
            // 3.3 将删除目标节点转移成 minP
            p = minP;
            pp = minPP;
        }

        // 4、处理 p 至多只有一个节点的情况
        Node child;// p 的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;// p 是叶子节点的情况
        }

        // 5、更新父节点的指针
        if (pp == null) {
            // 5.1 如果 p 没有父节点，说明 p 是根节点，更新 root 指针
            root = child;
        } else if (pp.left == p) {
            // 5.2 如果 p 是 pp 的左子节点，将 pp 的左指针指向 child
            pp.left = child;
        } else {
            // 5.3 如果 p 是 pp 的右子节点，将 pp 的右指针指向 child
            pp.right = child;
        }
    }

    private void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 层序遍历
     */
    private void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 查找后继结点
     * 后继节点可以通过以下两种情况找到：
     * 1、如果节点有右子树，那么后继节点是其右子树中的最小节点（最左边的节点）。
     * 2、如果节点没有右子树，那么后继节点是该节点的最低祖先节点，同时该祖先节点的左子节点也是该节点的一个祖先。
     */
    public Node findSuccessor(Node root, Node node) {
        if (node == null) {
            return null;
        }
        // 如果节点有右子树，则后继在右子树中的最小节点
        if (node.right != null) {
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        // 如果节点没有右子树，则需要从根节点向下搜索后继,即最低祖先节点
        Node successor = null;
        Node cur = root;
        while (cur != null) {
            if (node.data < cur.data) {
                successor = cur;
                cur = cur.left;
            } else if (node.data > cur.data) {
                successor = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        return successor;
    }


    /**
     * 查找前驱节点（Predecessor）
     * 前驱节点可以通过以下两种情况找到：
     * 1、如果节点有左子树，那么前驱节点是其左子树中的最大节点（最右边的节点）。
     * 2、如果节点没有左子树，那么前驱节点是该节点的最低祖先节点，同时该祖先节点的右子节点也是该节点的一个祖先。
     */
    public Node findPredecessor(Node root, Node node) {
        if (node == null) {

        }
        // 如果节点有左子树，则前驱在左子树中的最大节点
        if (node.left != null) {
            Node predecessor = node.left;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            return predecessor;
        }

        // 如果节点没有左子树，则需要从根节点向下搜索前驱
        Node predecessor = null;
        Node current = root;
        while (current != null) {
            if (node.data > current.data) {
                predecessor = current;
                current = current.right;
            } else if (node.data < current.data) {
                predecessor = current;
                current = current.left;
            } else {
                break;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(33);
        bst.insert(16);
        bst.insert(50);
        bst.insert(13);
        bst.insert(18);
        bst.insert(34);
        bst.insert(58);
        bst.insert(15);
        bst.insert(17);
        bst.insert(25);
        bst.insert(51);
        bst.insert(66);
        bst.insert(19);
        bst.insert(27);
        bst.printTree();

        bst.delete(13);
        bst.printTree();

        bst.delete(18);
        bst.printTree();

        bst.delete(55);
        bst.printTree();

        System.out.println("pre order root: ");
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();

        System.out.println("in order root: ");
        bst.inOrder();
        System.out.println();

        System.out.println("post order root: ");
        bst.postOrder();
        System.out.println();

        System.out.println("level order root: ");
        bst.levelOrder();
        System.out.println();

        int data = 50;
        Node node = bst.find(data);
        System.out.println(data + " successor: " + bst.findSuccessor(bst.root, node));
        System.out.println(data + " predecessor: " + bst.findPredecessor(bst.root, node));

        System.out.println("maxDepth:" + maxDepth(bst.root));

    }

    public static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void printTree() {
        int maxLevel = maxLevel(root);
        printNode(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNode(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) System.out.print("/");
                else printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) System.out.print("\\");
                else printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNode(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private int maxLevel(Node node) {
        if (node == null) return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) {
            if (node != null) return false;
        }
        return true;
    }
}
