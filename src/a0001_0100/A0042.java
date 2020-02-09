package a0001_0100;

public class A0042 {
    class Solution {
        public int trap(int[] height) {
            // 左边最高 和 右边 最高
            if (height.length < 2) return 0;
            int[] leftMax = new int[height.length], rightMax = new int[height.length];
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
                rightMax[height.length - 1 - i] = Math.max(rightMax[height.length - i], height[height.length - i]);
            }
            int res = 0, min;
            for (int i = 0; i < height.length; i++) {
                res += (min = Math.min(rightMax[i], leftMax[i])) > height[i] ? min - height[i] : 0;
            }
            return res;
        }
    }
}
