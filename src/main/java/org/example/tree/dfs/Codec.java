package org.example.tree.dfs;

import java.util.LinkedList;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 */
public class Codec {

    private static String SEP = ",";
    private static String NULL = "#";

    /**
     * 序列化二叉树为字符串，使用前序遍历方法
     *
     * @param root 二叉树的根节点
     * @return 序列化后的字符串
     */
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeHelper(root, sb);
        return sb.toString();
    }

    /**
     * 辅助方法，递归进行前序遍历序列化
     *
     * @param node 当前遍历的节点
     * @param sb   序列化后的字符串
     */
    private void serializeHelper(TreeNode node, StringBuffer sb) {
        // 如果当前节点为空，添加空节点标识符 "#"
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // ***前序遍历位置***
        // 记录当前节点的值，并添加分隔符
        sb.append(node.val).append(SEP);
        // ****************

        // 递归序列化左子树和右子树
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    /**
     * 反序列化字符串为二叉树
     *
     * @param data 序列化后的字符串
     * @return 反序列化后的二叉树根节点
     */
    public TreeNode deserialize(String data) {
        // 将序列化的字符串按分隔符拆分成节点列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.add(s);
        }
        // 递归反序列化
        return deserializeHelper(nodes);
    }

    /**
     * 辅助方法，递归进行前序遍历反序列化
     *
     * @param nodes 节点值的的队列
     * @return 构建的二叉树节点
     */
    private TreeNode deserializeHelper(LinkedList<String> nodes) {
        // 如果节点队列为空，表示没有更多节点需要反序列化
        if (nodes.isEmpty()) {
            return null;
        }

        // ***前序遍历位置***
        // 最左侧就是根节点,获取当前节点值，并移除队列中的第一个元素
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        // 构造当前节点
        TreeNode root = new TreeNode(Integer.valueOf(first));
        // ****************

        // 递归构建左子树和右子树
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeUtil.printTree(root);
        // 测试序列化
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized); // 序列化输出

        // 测试反序列化
        TreeNode deserializedRoot = codec.deserialize(serialized);
        TreeUtil.printTree(deserializedRoot);
        String deserializedSerialized = codec.serialize(deserializedRoot);
        System.out.println("Deserialized and Serialized again: " + deserializedSerialized); // 反序列化后再次序列化

    }
}
