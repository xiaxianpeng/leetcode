package org.example.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/12 10:02 AM
 *
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；
 * 该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 *
 * 实现扁平迭代器类 NestedIterator ：
 *
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 *
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：[1,1,2,1,1]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2：
 *
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：[1,4,6]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class NestedIterator implements Iterator<Integer> {

    public static interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    Deque<Integer> queue = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // 初始化的时候dfs,入队列
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.pollFirst() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void dfs(List<NestedInteger> list) {
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                queue.addLast(item.getInteger());
            } else {
                dfs(item.getList());
            }
        }
    }
}
