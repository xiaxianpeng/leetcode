package org.example.lru.doublelist;

import java.util.HashMap;

/**
 * LRU(Least Recently Used)-最近最少使用缓存
 * 具体实现步骤：
 * 1、使用哈希表存储数据的键值对，键为缓存的键，值为对应的节点。
 * 2、使用双向链表存储数据节点，链表头部为最近访问的节点，链表尾部为最久未访问的节点。
 * 3、使用双向链表存储数据节点，链表头部为最近访问的节点，链表尾部为最久未访问的节点。
 * 4、当缓存空间已满时，需要淘汰最久未访问的节点，即链表尾部的节点。
 * ******
 * LRU 算法可以在 O(1) 的时间复杂度内实现数据的插入、查找和删除操作。
 * 每次访问数据时，都会将对应的节点移动到链表头部，保证链表头部的节点是最近访问的数据，
 * 而链表尾部的节点是最久未访问的数据。当缓存空间不足时，淘汰链表尾部的节点即可。
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
