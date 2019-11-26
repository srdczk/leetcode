package a0001_0100;

import java.util.ArrayList;
import java.util.List;

public class A0060 {
    class Solution {
        private int[] a;
        private void init() {
            a = new int[10];
            a[0] = 1;
            a[1] = 1;
            for (int i = 2; i < a.length; i++) a[i] = a[i - 1] * i;
        }
        public String getPermutation(int n, int k) {
            init();
            // 给定的 k 不需要进行验证
            // 然后在之前的排除
            StringBuilder res = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) list.add(i);
            k--;
            for (int i = 0; i < n; ++i) {
                // 第 k 位的数字
                int index = k / (a[n - i - 1]);
                res.append(list.get(index));
                list.remove(index);
                k %= a[n - i - 1];
            }
            return res.toString();
        }
    }
}
