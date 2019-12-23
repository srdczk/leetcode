package a0201_0300;

import java.util.ArrayList;
import java.util.List;

public class A0241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList<>();
            String[] ss = input.split("\\+|\\-|\\*");
            if (ss.length == 1) {
                res.add(Integer.parseInt(input));
                return res;
            }
            int cnt = 0;
            for (String s : ss) {
                cnt += s.length();
                if (cnt < input.length()) {
                    List<Integer> left = diffWaysToCompute(input.substring(0, cnt)), right = diffWaysToCompute(input.substring(cnt + 1));
                    for (int a : left) {
                        for (int b : right) {
                            switch (input.charAt(cnt)) {
                                case '+':
                                    res.add(a + b);
                                    break;
                                case '-':
                                    res.add(a - b);
                                    break;
                                case '*':
                                    res.add(a * b);
                                    break;
                            }
                        }
                    }
                } else break;
                cnt++;
            }
            return res;
        }
    }
}
