package org.example.map;

/**
 * @author xianpeng.xia
 * on 2021/2/8 3:09 下午
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
