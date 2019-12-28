package a0601_0700;

import java.util.PriorityQueue;

public class A0670 {
    class Solution {
        private void swap(char[] chs, int i, int j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
        }
        public int maximumSwap(int num) {
            char[] chs = String.valueOf(num).toCharArray();
            if (chs.length < 2) return num;
            int[] leftMax = new int[chs.length];
            leftMax[leftMax.length - 2] = leftMax.length - 1;
            for (int i = leftMax.length - 3; i > -1; i--) {
                if (chs[i + 1] > chs[leftMax[i + 1]]) leftMax[i] = i + 1;
                else leftMax[i] = leftMax[i + 1];
            }
            for (int i = 0; i < chs.length - 1; i++) {
                if (chs[leftMax[i]] > chs[i]) {
                    swap(chs, leftMax[i], i);
                    return Integer.parseInt(new String(chs));
                }
            }
            return num;
        }
    }
}
