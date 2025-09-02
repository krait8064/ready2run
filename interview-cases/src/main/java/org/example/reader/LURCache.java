package org.example.reader;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by krait8064 at 2019/12/16
 */
public class LURCache<K, V> extends LinkedHashMap<K, V> {
    int capacity;

    public LURCache(int initialCapacity) {
        super(initialCapacity);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    static class ILRU {
        class Node {
            int key, value;
            Node pre, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                pre = this;
                next = this;
            }
        }

        private final int capacity;// LRU Cache的容量
        private Node dummy;// dummy节点是一个冗余节点，dummy的next是链表的第一个节点，dummy的pre是链表的最后一个节点
        private Map<Integer, Node> cache;//保存key-Node对，Node是双向链表节点

        public ILRU(int capacity) {
            this.capacity = capacity;
            dummy = new Node(0, 0);
            cache = new ConcurrentHashMap<>();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            remove(node);
            add(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                if (cache.size() >= capacity) {
                    cache.remove(dummy.next.key);
                    remove(dummy.next);
                }
            } else {
                cache.remove(node.key);
                remove(node);
            }
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        }

        /**
         * 在链表尾部添加新节点
         *
         * @param node 新节点
         */
        private void add(Node node) {
            dummy.pre.next = node;
            node.pre = dummy.pre;
            node.next = dummy;
            dummy.pre = node;
        }

        /**
         * 从双向链表中删除该节点
         *
         * @param node 要删除的节点
         */
        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
}
