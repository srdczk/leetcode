package a0401_0500;

public class A0470 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    class SolBase {
        public int rand7() {return 0;}
    }
    class Solution extends SolBase {
        private int getLarge10() {
            int res;
            while ((res = 7 * (rand7() - 1) + rand7() - 1) > 39);
            return res;
        }
        public int rand10() {
            // 套路 -- 通过 r7 * (rand7() - 1) + rand7() - 1 构造 0 - 48 等概率的
            return getLarge10() % 10 + 1;
        }
    }
}
