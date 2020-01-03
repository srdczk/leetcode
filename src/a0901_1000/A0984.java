package a0901_1000;
// Created by srdczk on 2020/1/3

public class A0984 {
    class Solution {
        private String process(int x, int y, char a, char b) {
            StringBuilder res = new StringBuilder();
            if (x % 2 == 0) {
                if (y < x / 2 - 1) return "";
                else if (y == x / 2 - 1) {
                    for (int i = 0; i < y; i++) {
                        res.append(a).append(a).append(b);
                    }
                    res.append(a).append(a);
                } else {
                    int cnt = y - x / 2;
                    for (int i = 0; i < cnt; i++) {
                        res.append(a).append(a).append(b).append(b);
                    }
                    for (int i = 0; i < x / 2 - cnt; i++) {
                        res.append(a).append(a).append(b);
                    }
                }
            } else {
                if (y < x / 2) return "";
                else if (y == x / 2) {
                    for (int i = 0; i < y; i++) {
                        res.append(a).append(a).append(b);
                    }
                    res.append(a);
                } else {
                    int cnt = y - x / 2 - 1;
                    for (int i = 0; i < cnt; i++) {
                        res.append(a).append(a).append(b).append(b);
                    }
                    for (int i = 0; i < x / 2 + 1 - cnt; i++) {
                        if (i == x / 2 - cnt) res.append(a).append(b);
                        else res.append(a).append(a).append(b);
                    }
                }
            }
            return res.toString();
        }
        public String strWithout3a3b(int A, int B) {
            if (A > B) return process(A, B, 'a', 'b');
            else return process(B, A, 'b', 'a');
        }
    }
}
