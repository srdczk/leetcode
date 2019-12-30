package a0601_0700;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/29
 * @Description: a0601_0700
 * @version: 1.0
 */
public class A0699 {
    // 线段树 单点更新
    // 线段树 区间 更新的解法, 懒惰数组标记 <---> 表示这个节点已经更新过了, 但是子树还没有进行更新
    // 更新线段树的时候, 只需要排序即可, 不需要把全部的大小表示出来
    class Solution {
        private int[] tree;
        private int[] lazy;

        private void pointUpdate(int treeIndex, int L, int R, int i, int val) {
            if (L == R) {
                tree[treeIndex] = Math.max(val, tree[treeIndex]);
                return;
            }
            int mid = L + ((R - L) >> 1);
            if (i <= mid) pointUpdate(2 * treeIndex + 1, L, mid, i, val);
            else pointUpdate(2 * treeIndex + 2, mid + 1, R, i, val);
            pushUp(treeIndex);
        }
        // treeIndex L R 表示 这颗树
        private int pointGet(int treeIndex, int L, int R, int l, int r) {
            if (L >= l && R <= r) return tree[treeIndex];
            int res = Integer.MIN_VALUE;
            int mid = L + ((R - L) >> 1);
            if (l <= mid) res = Math.max(pointGet(2 * treeIndex + 1, L, mid, l, r), res);
            if (r > mid) res = Math.max(res, pointGet(2 * treeIndex + 2, mid + 1, R, l, r));
            return res;
        }

        private void pushUp(int treeIndex) {
            tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }

        private List<Integer> pointUpdateSolve(int[][] positions) {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> x - y);
            for (int[] pos : positions) {
                queue.offer(pos[0]);
                queue.offer(pos[1] + pos[0] - 1);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int index = 0, max = 0;
            while (!queue.isEmpty()) {
                int q = queue.poll();
                if (!map.containsKey(q)) map.put(q, index++);
            }
            tree = new int[index << 2];
            int begin = 0, end = index - 1;
            for (int[] pos : positions) {
                int p = map.get(pos[0]), q = map.get(pos[0] + pos[1] - 1);
                int h = pointGet(0, begin, end, p, q);
                max = Math.max(max, h + pos[1]);
                for (int i = p; i < q + 1; i++) pointUpdate(0, begin, end, i, h + pos[1]);
                res.add(max);
            }
            return res;
        }

        private void pushDown(int treeIndex, int L, int R) {
            if (treeIndex < 0 || treeIndex > tree.length - 1 || L > R) return;
            //  节点已经更新, 但是子树 还未更新 <--->
            if (lazy[treeIndex] != 0) {
                tree[treeIndex] = lazy[treeIndex];
                // 当 有子树的时候
                if (L < R) {
                    lazy[2 * treeIndex + 1] = lazy[treeIndex];
                    lazy[2 * treeIndex + 2] = lazy[treeIndex];
                }
                lazy[treeIndex] = 0;
            }
        }

        private void update(int treeIndex, int L, int R, int l, int r, int val) {
            pushDown(treeIndex, L, R);

            if (L >= l && r <= R) {
                tree[treeIndex] = val;
                // 子数标记为 lazy
                if (L < R) {
                    lazy[2 * treeIndex + 1] = val;
                    lazy[2 * treeIndex + 2] = val;
                }
                return;
            }

            if (l > R || r < L || l > r) return;

            int mid = L + ((R - L) >> 1);
            if (l <= mid) update(2 * treeIndex + 1, L, mid, l, r, val);
            if (r > mid) update(2 * treeIndex + 2, mid + 1, R, l, r, val);
            pushUp(treeIndex);

        }

        private int get(int treeIndex, int L, int R, int l, int r) {
            // get 的 时候 重新 update 一遍
            // 会 更新到最底层
            pushDown(treeIndex, L, R);
            if (L >= l && r <= R) return tree[treeIndex];
            int res = Integer.MIN_VALUE;
            int mid = L + ((R - L) >> 1);
            if (l <= mid) res = Math.max(res, get(2 * treeIndex + 1, L, mid, l, r));
            if (r > mid) res = Math.max(res, get(2 * treeIndex + 2, mid + 1, R, l, r));
            return res;
        }

        private List<Integer> solve(int[][] positions) {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> x - y);
            for (int[] pos : positions) {
                queue.offer(pos[0]);
                queue.offer(pos[1] + pos[0] - 1);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int index = 0, max = 0;
            while (!queue.isEmpty()) {
                int q = queue.poll();
                if (!map.containsKey(q)) map.put(q, index++);
            }
            tree = new int[index << 2];
            lazy = new int[index << 2];
            int begin = 0, end = index - 1;
            for (int[] pos : positions) {
                int p = map.get(pos[0]), q = map.get(pos[0] + pos[1] - 1);
                int h = get(0, begin, end, p, q);
                max = Math.max(max, h + pos[1]);
                update(0, begin, end, p, q, h + pos[1]);
                res.add(max);
            }
            return res;
        }

        public List<Integer> fallingSquares(int[][] positions) {
//            return pointUpdateSolve(positions);
            return solve(positions);
        }
    }
}
