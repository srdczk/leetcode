package a0001_0100;

public class A0042 {
    class Solution {
        public int trap(int[] a) {
            int[] leftMax = new int[a.length], rightMax = new int[a.length];
            for (int i = 1; i < a.length; i++) {
                leftMax[i] = Math.max(a[i - 1], leftMax[i - 1]);
                rightMax[a.length - 1 - i] = Math.max(rightMax[a.length - i], a[a.length - i]);
            }
            int res = 0;
            for (int i = 0; i < a.length; i++) {
                res += Math.max(0, Math.min(rightMax[i], leftMax[i]) - a[i]);
            }
            return res;
        }
    }
}
