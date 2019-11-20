package a0201_0300;

public class A0206 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int v) {
            val = v;
            next = null;
        }
    }
    class Solution {
        // 反转链表 -> 递归 或 迭代

        private ListNode iterateSolve(ListNode node) {
            if (node == null || node.next == null) return node;

            ListNode p = node.next;
            node.next = null;
            while (p != null) {
                ListNode tmp = p.next;

                p.next = node;
                node = p;

                p = tmp;

            }
            return node;
        }

        private ListNode recursiveSolve(ListNode node) {
            return reverse(null, node);
        }

        private ListNode reverse(ListNode pre, ListNode node) {
            if (node == null) return pre;
            ListNode next = node.next;
            node.next = pre;
            return reverse(node, next);
        }

        public ListNode reverseList(ListNode head) {
//            return iterateSolve(head);
            return recursiveSolve(head);
        }
    }
}
