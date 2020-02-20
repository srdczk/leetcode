package a0701_0800;

/**
 * create by srdczk 20-2-20
 */
public class A0771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            int cnt[] = new int[128], res = 0;
            for (char c : J.toCharArray()) cnt[c]++;
            for (char c : S.toCharArray()) {
                if (cnt[c] > 0) res++;
            }
            return res;
        }
    }
}
