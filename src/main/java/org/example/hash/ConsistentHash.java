package org.example.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性哈希
 * doc:https://www.zsythink.net/archives/1182
 */
public class ConsistentHash {

    private final SortedMap<Integer, String> circle = new TreeMap<>();

    public void addNode(String node) {
        int hash = getHash(node);
        circle.put(hash, node);
    }

    public void removeNode(String node) {
        int hash = getHash(node);
        circle.remove(hash);
    }

    public String getNode(String node) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = getHash(node);
        // 如果没有找到hash大于等于给定key的hash值，将会返回第一个node，形成环结构
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int getHash(String node) {
        return node.hashCode();
    }

    public static void main(String[] args) {
        ConsistentHash ch = new ConsistentHash();
        ch.addNode("NodeA");
        ch.addNode("NodeB");
        ch.addNode("NodeC");
        String nodeA = ch.getNode("NodeA");

        String nodeForKey = ch.getNode("myKey");
        // return:NodeA
        System.out.println("Node for myKey: " + nodeForKey);
    }
}
