package a0301_0400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A0331 {
    class Solution {

        private boolean build(Queue<String> queue) {
            if (queue.isEmpty()) return false;
            if (queue.poll().equals("#")) return true;
            return build(queue) && build(queue);
        }

        public boolean isValidSerialization(String preorder) {
            String[] ss = preorder.split(",");
//            for (String s : ss) System.out.print(s + " ");
            Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
            return build(queue) && queue.isEmpty();
        }
    }
}
