package a0101_0200;

import java.util.HashMap;

public class A0146 {
    // 实现 LRU cache, 使用 hash + 双链表, 注意双链表可以加上头节点和尾节点, 这样删除, 插入更加方便
    class LRUCache {

        private class Node {
            public int k, v;
            public Node pre, next;
            public Node(int k, int v) {
                this.k = k;
                this.v = v;
                next = null;
                pre = null;
            }
        }

        private int size;

        private HashMap<Integer, Node> map;

        private Node head, tail;

        public LRUCache(int capacity) {
            size = capacity;
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        private Node del(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            return node;
        }

        private Node insert(Node node) {
            Node pre = tail.pre;
            node.next = tail;
            tail.pre = node;
            node.pre = pre;
            pre.next = node;
            return node;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = del(map.get(key));
            insert(node);
            return node.v;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = del(map.get(key));
                node.v = value;
                insert(node);
            } else {
                if (map.size() < size) {
                    Node node = new Node(key, value);
                    insert(node);
                    map.put(node.k, node);
                } else {
                    Node node = head.next;
                    map.remove(node.k);
                    del(node);
                    node = new Node(key, value);
                    insert(node);
                    map.put(key, node);
                }
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
