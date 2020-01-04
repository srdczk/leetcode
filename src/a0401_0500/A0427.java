package a0401_0500;
// Created by srdczk on 2020/1/4

public class A0427 {
    class Node {
        public int id;
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    class Solution {
        private boolean isLeaf(int[][] a, int bx, int by, int len) {
            int x = a[bx][by];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (a[bx + i][by + j] != x) return false;
                }
            }
            return true;
        }
        private Node process(int[][] a, int bx, int by, int len) {
            if (isLeaf(a, bx, by, len)) return new Node(a[bx][by] != 0, true, null, null, null, null);
            return new Node(true, false
                    , process(a, bx, by, len / 2)
                    , process(a, bx, by + len / 2, len / 2)
                    , process(a, bx + len / 2, by, len / 2)
                    , process(a, bx + len / 2, by + len / 2, len / 2));
        }
        public Node construct(int[][] a) {
            return process(a, 0, 0, a.length);
        }
    }
}
