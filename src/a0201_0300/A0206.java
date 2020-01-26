package a0201_0300;

public class A0206 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
    }
    class Solution {
        private ListNode iterateSolve(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode node = head.next;
            head.next = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = head;
                head = node;
                node = next;
            }
            return head;
        }
        private ListNode process(ListNode pre, ListNode node) {
            if (node == null) return pre;
            ListNode next = node.next;
            node.next = pre;
            return process(node, next);
        }
        private ListNode recurSolve(ListNode head) {
            if (head == null || head.next == null) return head;
            return process(null, head);
        }
        public ListNode reverseList(ListNode head) {
//            return iterateSolve(head);
            return recurSolve(head);
        }
    }
}
