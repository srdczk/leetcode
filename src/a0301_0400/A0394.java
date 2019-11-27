package a0301_0400;

public class A0394 {
    class Solution {
        private char[] chs;

        private String process(int i, int j) {
            StringBuilder res = new StringBuilder();
            if (i == j) return String.valueOf(chs[i]);
            else if (i > j) return "";
            while (i < j + 1) {
                if (Character.isDigit(chs[i])) {
                    int x = 0;
                    while (Character.isDigit(chs[i])) x = x * 10 + chs[i++] - '0';
                    i++;
                    int t = i;
                    int s = 1;
                    while (i < j + 1 && s != 0) {
                        if (chs[i] == '[') s++;
                        else if (chs[i] == ']') s--;
                        i++;
                    }
                    String p = process(t, i - 2);
                    for (int k = 0; k < x; k++) {
                        res.append(p);
                    }
                } else res.append(chs[i++]);
            }
            return res.toString();
        }

        public String decodeString(String s) {
            chs = s.toCharArray();
            return process(0, chs.length - 1);
        }
    }
}
