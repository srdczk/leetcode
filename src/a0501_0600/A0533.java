package a0501_0600;

import java.util.HashMap;

public class A0533 {
    class Solution {
        public int findBlackPixel(char[][] picture, int N) {
            if (picture.length == 0 || picture[0].length == 0) return 0;
            HashMap<Integer, Integer> iMap = new HashMap<>(), jMap = new HashMap<>();
            HashMap<Integer, String> map = new HashMap<>();
            for (int i = 0; i < picture.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < picture[0].length; j++) {
                    sb.append(picture[i][j]);
                    if (picture[i][j] == 'B') {
                        iMap.put(i, iMap.getOrDefault(i, 0) + 1);
                        jMap.put(j, jMap.getOrDefault(j, 0) + 1);
                    }
                }
                map.put(i, sb.toString());
            }
            int res = 0;
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        if (iMap.getOrDefault(i, 0) == N && jMap.getOrDefault(j, 0) == N) {
                            String s = null;
                            boolean x = true;
                            for (int k = 0; k < picture.length; k++) {
                                if (picture[k][j] == 'B') {
                                    if (s == null) s = map.get(k);
                                    else if (!s.equals(map.get(k))) {
                                        x = false;
                                        break;
                                    }
                                }
                            }
                            if (x) res++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
