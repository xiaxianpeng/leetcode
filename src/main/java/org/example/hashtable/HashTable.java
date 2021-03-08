package org.example.hashtable;

import java.util.TreeMap;

/**
 * @date 2021/03/08
 * @time 20:11
 * 哈希表
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;


    public HashTable(int m) {
        this.M = m;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

}
