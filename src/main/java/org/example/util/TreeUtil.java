package org.example.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.tree.TreeNode;

/**
 * Created on 2024/11/15 23:50
 */
public class TreeUtil {
    // 私有构造函数，防止实例化工具类
    private TreeUtil() {
    }

    // 打印树的方法
    public static void printTree(TreeNode root) {
        int maxLevel = maxLevel(root);  // 计算树的最大深度
        printNode(Collections.singletonList(root), 1, maxLevel); // 打印树的节点
    }

    // 计算树的最大深度
    private static int maxLevel(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    // 打印树的递归方法，逐层打印每个节点
    private static void printNode(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);  // 打印当前层的前置空格

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" "); // 空节点位置打印空格
            }

            printWhitespaces(betweenSpaces); // 打印节点之间的空格
        }
        System.out.println();

        // 打印连接线
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i); // 打印每一层连接线的前置空格

                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                // 打印左子节点的连接线（如果有）
                if (nodes.get(j).left != null) System.out.print("/");
                else printWhitespaces(1);

                // 打印左右子节点之间的空格
                printWhitespaces(i + i - 1);

                // 打印右子节点的连接线（如果有）
                if (nodes.get(j).right != null) System.out.print("\\");
                else printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i); // 打印每一层连接线后的空格
            }

            System.out.println();
        }

        printNode(newNodes, level + 1, maxLevel); // 递归打印下一层节点
    }

    // 打印空格
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    // 判断列表中的所有元素是否为 null
    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node != null) return false;
        }
        return true;
    }

}
