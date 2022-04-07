package org.example.tree.bst;

import java.util.ArrayList;
import org.example.tree.TreeNode;

/**
 * @author xianpeng.xia
 * on 2022/3/30 7:39 AM
 * 给定⼀个有相同值的⼆叉搜索树（BST），
 * 找出 BST 中的所有众数（出现频率最⾼的元素）。
 *
 * 例如给定 BST [1,null,2,2]，返回 [2]。
 * 提示：如果众数超过 1 个，不需考虑输出顺
 */
public class FindMode {

    ArrayList<Integer> mode = new ArrayList<>();
    TreeNode prev = null;
    // 当前元素的重复次数
    int curCount = 0;
    // 全局的最长相同序列长度
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        // 执行中序遍历
        traverse(root);
        int[] res = new int[mode.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        /***执行中序位置***/
        if (prev == null) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.add((Integer) root.val);
        } else {
            if ((Integer) root.val == prev.val) {
                // root.val重复的情况
                curCount++;
                if (curCount == maxCount) {
                    // root.val是众数
                    mode.add((Integer) root.val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode.clear();
                    maxCount = curCount;
                    mode.add((Integer) root.val);
                }
            }

            if ((Integer) root.val != (Integer) prev.val) {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount == maxCount) {
                    mode.add((Integer) root.val);
                }
            }

        }
        // 更新prev
        prev = root;
        /****************/
        traverse(root.right);
    }
}
