package org.example.tree;

import java.util.LinkedList;

/**
 * @author xianpeng.xia
 * on 2022/3/29 12:39 AM
 *
 * ⼆叉树的序列化与反序列化
 *
 * 输⼊：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class Codec {

    String SEP = ",";
    String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
        }
        // ***前序遍历位置***
        sb.append(root.val).append(SEP);
        // ****************
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.add(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // ***前序遍历位置***
        // 最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(first);
        // ****************
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    public static class TreeNode {

        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
