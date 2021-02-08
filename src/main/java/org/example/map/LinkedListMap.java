package org.example.map;

/**
 * @author xianpeng.xia
 * on 2021/2/8 3:19 下午
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this.key = key;
            this.value = null;
            this.next = null;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.key + " : " + cur.value + " -> ");
            cur = cur.next;
        }
        sb.append("Null");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListMap<String, String> map = new LinkedListMap();
        map.add("a", "a");
        map.add("b", "b");
        map.add("c", "c");
        System.out.println(map);
        map.set("c", "c1");
        System.out.println(map);
        map.remove("a");
        System.out.println(map);
    }
}
