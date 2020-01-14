package a0501_0600;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;

public class A0531 {
    class Solution {
        public int findLonelyPixel(char[][] picture) {
            if (picture.length == 0 || picture[0].length == 0) return 0;
            HashMap<Integer, Integer> iMap = new HashMap<>(), jMap = new HashMap<>();
            int res = 0;
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        iMap.put(i, iMap.getOrDefault(i, 0) + 1);
                        jMap.put(j, jMap.getOrDefault(j, 0) + 1);
                    }
                }
            }
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        if (iMap.getOrDefault(i, 0) == 1 &&
                                jMap.getOrDefault(j, 0) == 1) res++;
                    }
                }
            }
            return res;
        }
    }
}
