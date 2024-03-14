package org.example.lru;

import java.util.LinkedHashMap;

/**
 * @author xianpeng.xia
 * on 2022/4/1 4:54 PM
 * LRU(最近最少使用)缓存
 */
public class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改key的值
            cache.put(key, val);
            // 将key变为最近使用
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.capacity) {
            // 链表头部就是最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的key添加到链表尾部
        cache.put(key, val);
    }

    public void makeRecently(int key) {
        int val = cache.get(key);
        // 删除key，重新插入到队列尾
        cache.remove(key);
        cache.put(key, val);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
            "capacity=" + capacity +
            ", cache=" + cache +
            '}';
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        for (int i = 1; i <= 10; i++) {
            cache.put(i, i);
        }
        cache.put(1, 1);
        System.out.println(cache);
        cache.put(11, 11);
        System.out.println(cache);
        cache.put(10, 1);
        System.out.println(cache);
    }
}
