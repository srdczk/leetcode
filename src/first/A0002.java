package first;

/**
 * created by srdczk 2019/11/6
 */
public class A0002 {
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
        ListNode (int v) {
            val = v;
        }
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode a, ListNode b) {
            ListNode res = new ListNode(0), p = res;
            int l = 0;
            while (a != null || b != null) {
                if (a != null && b != null) {
                    int m = a.val + b.val + l;
                    if (m > 9) {
                        a.val = m - 10;
                        l = 1;
                    } else {
                        a.val = m;
                        l = 0;
                    }
                    p.next = a;
                    a = a.next;
                    b = b.next;
                    p = p.next;
                } else if (a != null) {
                    int m = a.val + l;
                    if (m > 9) {
                        a.val = m - 10;
                        l = 1;
                    } else {
                        a.val = m;
                        l = 0;
                    }
                    p.next = a;
                    a = a.next;
                    p = p.next;
                } else {
                    int m = b.val + l;
                    if (m > 9) {
                        b.val = m - 10;
                        l = 1;
                    } else {
                        b.val = m;
                        l = 0;
                    }
                    p.next = b;
                    b = b.next;
                    p = p.next;
                }
            }
            if (l > 0) p.next = new ListNode(1);
            return res.next;
        }
    }
}
