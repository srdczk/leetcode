package a0101_0200;

public class A0186 {
    class Solution {
        public void reverseWords(char[] s) {
            String[] ss = new String(s).split(" ");
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ss.length; j++) {
                sb.append(ss[ss.length - 1 - j]).append(' ');
            }
            while (i < s.length) {
                s[i] = sb.charAt(i++);
            }
        }
    }
}