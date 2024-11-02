package org.example.tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;
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

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        // 新插入的数据一般都是在叶子节点上，
        // 所以我们只需要从根节点开始，依次比较要插入的数据和节点的大小关系。
        Node p = tree;
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

    public void delete(int data) {
        // p 指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp 记录的是 p 的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            // 没有找到
            return;
        }

        // 1、要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // // 将 minP 的数据替换到 p 中
            p.data = minP.data;
            // // 下面就变成了删除 minP 了
            p = minP;
            pp = minPP;
        }

        // 2、删除节点是叶子节点或者仅有一个子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        // 3、删除的节点是根节点
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
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
    }


    public void printTree() {
        int maxLevel = maxLevel(tree);
        printNode(Collections.singletonList(tree), 1, maxLevel);
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
