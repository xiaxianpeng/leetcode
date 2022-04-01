package org.example.lru.doublelist;

import java.util.HashMap;

/**
 * @author xianpeng.xia
 * on 2022/4/1 5:40 PM
 */
public class LRUCache {

    /**
     * key -> Node(key,val)
     */
    private HashMap<Integer, Node> map;
    /**
     * Node(k1,v1) <-> Node(k2,v2)...
     */
    private DoubleList cache;
    /**
     * 最大容量
     */
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // 删除旧数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }
        if (capacity == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, val);
    }

    private void makeRecently(int key) {
        Node x = map.get(key);
        // 先删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // map中添加key的映射
        map.put(key, x);
    }

    private void deleteKey(int key) {
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从map中删除
        map.remove(key);
    }

    /**
     * 删除最久未使⽤的元素
     */
    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int key = deleteNode.key;
        map.remove(key);
    }
}
