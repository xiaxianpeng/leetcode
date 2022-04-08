package org.example.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xianpeng.xia
 * on 2022/4/8 5:33 PM
 * 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * 提示：
 *
 * 2 <= asteroids.length <= 10 ^ 4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * 示例
 *
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 *
 * 示例 2：
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 *
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 * 示例 4：
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。
 * 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 *
 *
 * 作者：qingfengpython
 * 链接：https://leetcode-cn.com/problems/XagZNi/solution/shua-chuan-jian-zhi-offer-day17-zhan-i-0-5yho/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class AsteroidCollision {

    /**
     * @param asteroids 行星
     * * 分析
     * * 这道栈的题目难点应该主要是在分析场景上了。
     * * 我们需要明确什么时候无脑入栈，什么时候需要判断，理解这两点就可以轻松解题了。
     * * 首先，循环每一个元素时，在什么情况下无脑入栈呢？
     * *
     * * 栈为空
     * * 栈顶元素为负数(下一个为负数则一起向左，下一个为正数则分向两边)
     * * 当前元素为正数（栈顶为正一起向右，栈顶为负分向两边）
     * * 下来，我们需要看碰撞的场景又细分为什么情况：
     * *
     * * 栈顶元素大于abs(当前元素)，当前元素被撞毁
     * * 栈顶元素等于abs(当前元素)，栈顶弹出和当前元素抵消
     * * 栈顶元素小于abs(当前元素)，栈顶弹出，并与新栈顶完成上述判断
     * * 最终返回栈即可。
     * *
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        while (p < asteroids.length) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[p] > 0) {
                stack.push(asteroids[p]);
            } else if (stack.peek() <= -asteroids[p]) {
                if (stack.pop() < -asteroids[p]) {
                    continue;
                }
            }
            p++;
        }
        int[] ret = new int[stack.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] asteroids = new int[]{5, 10, -5};
        System.out.println(Arrays.toString(asteroids));
        int[] asteroidCollision = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(asteroidCollision));
    }
}
