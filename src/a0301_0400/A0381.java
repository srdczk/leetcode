package a0301_0400;

import java.util.HashMap;

public class A0381 {
    class RandomizedCollection {
        private class Node {
            int val;
            Node next, pre;
            Node(int v) {
                val = v;
            }
        }

        private int size = 0;

        private Node head = new Node(0), tail = new Node(0);

        private HashMap<Integer, Node> map = new HashMap<>();
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            head.next = tail;
            tail.next = head;
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            size++;
            if (map.getOrDefault(val, null) != null) {
                // 包含 val
                Node oldNode = map.get(val), newNode = new Node(val);
                Node next = oldNode.next;
                newNode.next = next;
                next.pre = newNode;
                newNode.pre = oldNode;
                oldNode.next = newNode;
                return false;
            } else {
                // 不包含val
                Node node = new Node(val);
                Node next = head.next;
                node.next = next;
                next.pre = node;
                node.pre = head;
                head.next = node;
                map.put(val, node);
                return true;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            size--;
            if (map.getOrDefault(val, null) == null) return false;
            Node node = map.get(val);
            if (node.next == tail || node.next.val != node.val) map.put(val, null);
            else map.put(val, node.next);
            Node pre = node.pre, next = node.next;
            pre.next = next;
            next.pre = pre;
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int r = (int) (Math.random() * size);
            Node node = head.next;
            while (r-- > 0) {
                node = node.next;
            }
            return node.val;
        }
    }
}
