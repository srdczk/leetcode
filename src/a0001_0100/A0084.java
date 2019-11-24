package a0001_0100;

public class A0084 {
    class Solution {
        public int largestRectangleArea(int[] a) {
            if (a.length == 0) return 0;
            int[] leftMin = new int[a.length], rightMin = new int[a.length];
            leftMin[0] = -1;
            for (int i = 1; i < a.length; i++) {
                int k = i - 1;
                while (k > -1 && a[k] >= a[i]) k = leftMin[k];
                leftMin[i] = k;
            }
            rightMin[a.length - 1] = a.length;
            for (int i = a.length - 2; i > -1; i--) {
                int k = i + 1;
                while (k < a.length && a[k] >= a[i]) k = rightMin[k];
                rightMin[i] = k;
            }
            int res = 0;
            for (int i = 0; i < a.length; i++) {
                res = Math.max(res, (rightMin[i] - leftMin[i] - 1) * a[i]);
            }
            return res;
        }
    }
}
