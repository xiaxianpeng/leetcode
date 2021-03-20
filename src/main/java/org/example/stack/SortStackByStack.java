package org.example.stack;

/**
 * @date 2021/03/19
 * @time 16:04
 * 题目：
 * 在一个栈中元素的类型为整形,现在想将该栈从栈顶到栈底按从大到小的顺序排序,
 * 只许申请一个栈,除此之外,可以申请其他变量,但不能申请额外的数据结构
 * <p>
 * 解答:
 * 将待排序的栈标记为stack,辅助栈记做help,在stack上执行pop操作,弹出的元素记做cur
 * 如果cur小于等于help的栈顶元素,将cur直接压入help
 * 如果cur大于help的栈顶元素,则将hel的元素逐一弹出,逐一压入stack,
 * 直到cur小于等于help的栈顶元素,再将cur压入help
 * 一直执行以上操作,直到stack中的全部元素都压入help栈中(此时从栈顶到栈底:从小到大)
 * 最后将help栈中的元素逐一压入stack,即可完成排序
 */

import java.util.Stack;

public class SortStackByStack {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sort(stack);

        System.out.println();
    }
}
