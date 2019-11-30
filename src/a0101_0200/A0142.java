package a0101_0200;

import java.util.HashSet;
import java.util.Set;

public class A0142 {
    class ListNode {
        int val;
        ListNode next;
    }
    public class Solution {
        public ListNode detectCycle(ListNode node) {
            Set<ListNode> set = new HashSet<>();
            while (node != null && !set.contains(node)) {
                set.add(node);
                node = node.next;
            }
            return node;
        }
    }
}
