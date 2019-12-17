package a1101_1200;

public class A1103 {
    class Solution {
        // 每一轮所需要的数量
        // (1 + n) * n / 2 + (i * n * n)
        private int cntOnce(int n, int i) {
            return (1 + n) * n / 2 + (i * n * n);
        }
        public int[] distributeCandies(int candies, int num_people) {
             int[] res = new int[num_people];
             int x = 0, cnt, i = 0;
             while (candies >= (cnt = cntOnce(num_people, x))) {
                 candies -= cnt;
                 x++;
             }
            for (int j = 0; j < num_people; j++) {
                res[j] += (j + 1) * x;
                if (x > 0) res[j] += (x - 1) * x / 2 * num_people;
            }
            int q = 1 + x * num_people;
            while (candies > 0) {
                if (candies >= q) {
                    res[i] += q;
                    candies -= q;
                } else {
                    res[i] += candies;
                    candies = 0;
                }
                q++;
                i++;
                i %= num_people;
            }
            return res;
        }
    }
}
