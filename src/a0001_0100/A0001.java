package a0001_0100;

import java.util.HashMap;

/**
 * created by srdczk 2019/11/6
 */
public class A0001 {
    class Solution {
        public int[] twoSum(int[] a, int t) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                if (map.containsKey(t - a[i])) return new int[] {map.get(t - a[i]), i};
                map.put(a[i], i);
            }
            return new int[]{-1, -1};
        }
    }
}
