package a0301_0400;

public class A0383 {
    class Solution {
        private int[] cnt(char[] chs) {
            int[] res = new int[26];
            for (char c : chs) res[c - 'a']++;
            return res;
        }
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] a = cnt(ransomNote.toCharArray()), b = cnt(magazine.toCharArray());
            for (int i = 0; i < a.length; i++) {
                if (a[i] > b[i]) return false;
            }
            return true;
        }
    }
}
