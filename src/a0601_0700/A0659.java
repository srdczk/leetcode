package a0601_0700;

import java.util.HashMap;
import java.util.HashSet;

public class A0659 {
    class Solution {
        private HashMap<Integer, Integer> endMap = new HashMap<>();
        private HashMap<Integer, Integer> map = new HashMap<>();
        public boolean isPossible(int[] nums) {
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
            for (int num : nums) {
                if (map.getOrDefault(num, 0) == 0) continue;
                map.put(num, map.get(num) - 1);
                if (endMap.getOrDefault(num - 1, 0) > 0) {
                    endMap.put(num - 1, endMap.get(num - 1) - 1);
                    endMap.put(num, endMap.getOrDefault(num, 0) + 1);
                } else if (map.getOrDefault(num + 1, 0) > 0
                        && map.getOrDefault(num + 2, 0) > 0) {
                    map.put(num + 1, map.get(num + 1) - 1);
                    map.put(num + 2, map.get(num + 2) - 1);
                    endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
                }
                else return false;
            }
            return true;
        }
    }
}
