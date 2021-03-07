package org.example.map;

import org.example.tree.AVLTree;

/**
 * @author xianpeng.xia
 * on 2021/3/7 7:30 下午
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap() {
        this.avl = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.set(key, newValue);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    public static void main(String[] args) {
        AVLMap<String, Integer> map = new AVLMap<>();
        map.add("a", 1);
        map.add("b", 2);
        map.add("c", 3);
        map.add("d", 4);
        map.remove("d");
        System.out.println(map.contains("a"));
    }
}
