package a1201_1300;
// Created by srdczk on 2020/1/4

public class A1249 {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == ')') {
                    if (c == '(') {
                        sb.append(c);
                        cnt++;
                    } else {
                        if (cnt != 0) {
                            cnt--;
                            sb.append(c);
                        }
                    }
                } else sb.append(c);
            }
            if (cnt == 0) return sb.toString();
            StringBuilder res = new StringBuilder();
            int p = 0;
            for (char c : sb.reverse().toString().toCharArray()) {
                if (c == '(') {
                    if (p++ >= cnt) res.append(c);
                } else res.append(c);
            }
            return res.reverse().toString();
        }
    }
}
