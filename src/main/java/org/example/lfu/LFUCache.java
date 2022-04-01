package org.example.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author xianpeng.xia
 * on 2022/4/1 6:08 PM
 * LRU缓存
 */
public class LFUCache {

    /**
     * // key 到 val 的映射，KV表
     */
    HashMap<Integer, Integer> keyToVal;
    /**
     * // key 到 freq 的映射，我们后⽂称为 KF 表
     */
    HashMap<Integer, Integer> keyToFreq;

    /**
     * // freq 到 key 列表的映射，我们后⽂称为 FK 表
     */
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    /**
     * // 记录最⼩的频次
     */
    int minFreq;
    /**
     * // 记录 LFU 缓存的最⼤容量
     */
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }


    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加key对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (capacity <= 0) {
            return;
        }
        // 如果key存在，修改对应的val即可
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            // key 对应的 freq + 1
            increaseFreq(key);
            return;
        }
        // 如果不存在，需要插入
        // 容量满的话需要淘汰一个 freq 最小的 key
        if (capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }
        // 插入KV表
        keyToVal.put(key, val);
        // 插入KF表
        keyToFreq.put(key, 1);
        // 插入FK表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;

    }

    private void removeMinFreqKey() {
        // freq 最小的 key列表
        LinkedHashSet<Integer> keySet = freqToKeys.get(this.minFreq);

        // 最先插入的key就是最该被淘汰的key
        Integer deleteKey = keySet.iterator().next();
        keySet.remove(deleteKey);
        if (keySet.isEmpty()) {
            freqToKeys.remove(minFreq);
            /**
             * 其实这里没必要更新minFreq变量，因为你想想removeMinFreqKey这个函数是在什么时候调用？
             * 在put方法中插入新key时可能调用。而你回头看put的代码，
             * 插入新key时一定会把minFreq更新成 1，所以说即便这里minFreq变了，我们也不需要管它。
             */
        }
        /* 更新 KV 表 */
        keyToVal.remove(deleteKey);
        /* 更新 KF 表 */
        keyToFreq.remove(deleteKey);
    }


    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // 更新KF表
        // 将key从fre对应的列表删除
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        // 将key加入到 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq).add(key);

        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个freq是minFreq，则更新minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }


}
