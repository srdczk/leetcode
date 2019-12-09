package a0501_0600;

import javax.swing.text.ViewFactory;
import java.util.List;

public class A0524 {
    class Solution {
        private boolean can(String a, String b) {
            if (b.length() > a.length()) return false;
            if (a.length() == b.length()) return a.equals(b);
            char[] ca = a.toCharArray(), cb = b.toCharArray();
            int i = 0, j = 0;
            while (i < ca.length && j < cb.length) {
                while (i < ca.length && ca[i] != cb[j]) i++;
                if (i < ca.length) {
                    i++;
                    j++;
                }
            }
            return j == cb.length;
        }
        public String findLongestWord(String s, List<String> d) {
            String res = "";
            for (String c : d) {
                if (can(s, c)) {
                    if (c.length() > res.length()) res = c;
                    else if (c.length() == res.length() && c.compareTo(res) < 0) res = c;
                }
            }
            return res;
        }
    }
}
