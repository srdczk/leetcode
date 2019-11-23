package a0001_0100;

import java.util.Arrays;

public class A0031 {
    class Solution {
        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        public void nextPermutation(int[] a) {
            if (a.length < 2) return;
            if (a.length == 2) {
                swap(a, 0, 1);
                return;
            }
            int i = a.length - 1;
            while (i > 0 && a[i - 1] >= a[i]) i--;
            if (i == 0) {
                Arrays.sort(a);
                return;
            }
            int k = i;
            while (k < a.length && a[k] > a[i - 1]) k++;
            swap(a, k - 1, i - 1);
            Arrays.sort(a, i, a.length);
        }
    }
}
