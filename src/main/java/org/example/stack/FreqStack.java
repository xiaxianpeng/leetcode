package org.example.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author xianpeng.xia
 * on 2022/4/5 12:21 PM
 *
 * 最⼤栈
 *
 * 实现 FreqStack，模拟类似栈的数据结构的操作的⼀个类。
 * FreqStack 有两个⽅法： 1、push(int x)，将整数 x 推⼊栈中。 2、pop()，它移除并返回栈中出现最频繁的元素；如果最频繁的元素不只⼀个，则移除并返回最接近栈顶的 元素。 示例：输⼊：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","
 * pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释： 执⾏六次 .push 操作后，栈⾃底向上为 [5,7,5,7,4,5]。然后：
 * pop() -> 返回 5，因为 5 是出现频率最⾼的。 栈变成 [5,7,5,7,4]。
 * pop() -> 返回 7，因为 5 和 7 都是频率最⾼的，但 7 最接近栈顶。 栈变成 [5,7,5,4]。
 * pop() -> 返回 5。 栈变成 [5,7,4]。
 * pop() -> 返回 4。 栈变成 [5,7]
 */
public class FreqStack {

    /**
     * // 记录 FreqStack 中元素的最⼤频率
     */
    int maxFreq = 0;
    /**
     * // 记录 FreqStack 中每个 val 对应的出现频率，后⽂就称为 VF 表
     */
    HashMap<Integer, Integer> valToFreq = new HashMap<>();
    /**
     * // 记录频率 freq 对应的 val 列表，后⽂就称为 FV 表
     */
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();

    public void push(int val) {
        // 修改vf表
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        // 修改fv表
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);
        // 更新maxFreq
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> vals = freqToVals.get(maxFreq);
        int v = vals.pop();
        // 修改vf表，v对应的freq-1
        int freq = valToFreq.get(v) - 1;
        valToFreq.put(v, freq);
        // 更新maxFreq
        if (vals.isEmpty()) {
            maxFreq--;
        }
        return v;
    }
}
