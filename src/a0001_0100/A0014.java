package a0001_0100;

/**
 * create by srdczk 20-2-28
 */
public class A0014 {
    class Solution {
        private String commonPre(String a, String b) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (a.charAt(i) == b.charAt(i)) res.append(a.charAt(i));
                else break;
            }
            return res.toString();
        }
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            if (strs.length == 1) return strs[0];
            String res = commonPre(strs[0], strs[1]);
            for (int i = 2; i < strs.length; i++) res = commonPre(res, strs[i]);
            return res;
        }
    }
}
