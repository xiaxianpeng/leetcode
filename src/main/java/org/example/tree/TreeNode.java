package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 7:25 PM
 * 二叉树结构
 */
public class TreeNode<E> {

    public E val;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E val) {
        this.val = val;
        left = null;
        right = null;
    }
}
