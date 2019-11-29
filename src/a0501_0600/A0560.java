package a0501_0600;

import java.util.HashMap;

public class A0560 {
    // hash 表记录前 n 个 和为sum 的个数
    class Solution {
        public int subarraySum(int[] a, int k) {
            int res = 0, sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int c : a) {
                sum += c;
                if (map.containsKey(sum - k)) res += map.get(sum - k);
                if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
                else map.put(sum, 1);
            }
            return res;
        }
    }
}
