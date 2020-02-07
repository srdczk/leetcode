package a1301_1400;

public class A1310 {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            // x ^ y ^ x = y
            // cal pre sum of arr
            if (arr.length == 0) return arr;
            int[] preSum = new int[arr.length], res = new int[queries.length];
            preSum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                preSum[i] = preSum[i - 1] ^ arr[i];
            }
            int i = 0;
            for (int[] query : queries) {
                res[i++] = query[0] == 0 ? preSum[query[1]] : preSum[query[1]] ^ preSum[query[0] - 1];
            }
            return res;
        }
    }
}
