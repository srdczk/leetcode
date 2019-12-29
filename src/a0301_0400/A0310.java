package a0301_0400;

import java.util.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/29
 * @Description: a0301_0400
 * @version: 1.0
 */
public class A0310 {
    class Solution {
        private HashSet<Integer>[] adj;
        public List<Integer> findMinHeightTrees(int n, int[][] es) {
            List<Integer> res = new ArrayList<>();
            adj = new HashSet[n];
            int cnt = n;
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new HashSet<>();
            }
            for (int[] e : es) {
                adj[e[0]].add(e[1]);
                adj[e[1]].add(e[0]);
            }
            while (cnt > 2) {
                HashSet<Integer> del = new HashSet<>();
                for (int i = 0; i < p.length; i++) {
                    if (p[i] == 0) {
                        if (adj[i].size() == 1) {
                            del.add(i);
                            cnt--;
                        }
                    }
                }
                for (int i : del) {
                    int k = 0;
                    for (int c : adj[i]) k = c;
                    adj[k].remove(i);
                    p[i] = 1;
                }
            }
            for (int i = 0; i < p.length; i++) {
                if (p[i] == 0) res.add(i);
            }
            return res;
        }
    }
}
