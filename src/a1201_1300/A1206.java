package a1201_1300;

import java.util.Random;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/26
 * @Description: a1201_1300
 * @version: 1.0
 */
public class A1206 {
    class Skiplist {

        private static final int MAX_LEVEL = 16;
        private int levelCount = 1;
        private Node head = new Node();

        public Skiplist() {
        }

        public boolean search(int target) {
            Node p = head;
            for (int i = levelCount - 1; i > -1; i--) {
                while (p.next[i] != null && p.next[i].val < target) p = p.next[i];
            }
            if (p.next[0] != null && p.next[0].val == target) return true;
            return false;
        }

        public void add(int num) {
            int level = (int) (Math.random() * MAX_LEVEL) + 1;
            Node p = head;
            Node node = new Node();
            node.val = num;
            Node[] update = new Node[level];
            for (int i = level - 1; i > -1; i--) {
                while (p.next[i] != null && p.next[i].val < num) p = p.next[i];
                update[i] = p;
            }
            for (int i = level - 1; i > -1; i--) {
                node.next[i] = update[i].next[i];
                update[i].next[i] = node;
            }
            levelCount = Math.max(level, levelCount);
        }

        public boolean erase(int num) {
            boolean res = false;
            Node[] del = new Node[MAX_LEVEL];
            Node p = head;
            for (int i = levelCount - 1; i > -1; i--) {
                while (p.next[i] != null && p.next[i].val < num) p = p.next[i];
                del[i] = p;
            }
            for (int i = levelCount - 1; i > -1; i--) {
                if (del[i].next[i] != null && del[i].next[i].val == num) {
                    res = true;
                    del[i].next[i] = del[i].next[i].next[i];
                }
            }
            return res;
        }

        private class Node {
            private int val;
            private Node[] next = new Node[MAX_LEVEL];
        }
    }
}
