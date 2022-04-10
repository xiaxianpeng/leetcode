package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/10 11:18 PM
 *
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParenthesis {

    /**
     * 深度优先遍历
     *
     * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     * 当前左右括号都有大于 0 个可以使用的时候，才产生分支；
     * 产生左分支的时候，只看当前是否还有左括号可以使用；
     * 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
     * 在左边和右边剩余的括号数都等于 0 的时候结算。
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        // 深度优先遍历，探索可能出现的结果
        dfs("", n, n, ans);
        return ans;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left 左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param ans 结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> ans) {
        // 递归终止的时候，直接把它加入到结果集中即可
        if (left == 0 && right == 0) {
            ans.add(curStr);
            return;
        }
        // 剪枝(左括号可以使用的个数严格大于右括号可使用的个数)
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, ans);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, ans);
        }
    }

    public static void main(String[] args) {
        List<String> parenthesis = generateParenthesis(3);
        System.out.println(parenthesis);
    }
}
