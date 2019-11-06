package first;

/**
 * created by srdczk 2019/11/6
 */
public class A0004 {
    class Solution {

        private int findMid(int[] a, int[] b) {
            int p = (a.length + b.length + 1) / 2;
            int left = 0, right = a.length;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                //如果a的数量已经大于p了
                if (mid > p) right = mid - 1;
                else if (p - mid > b.length) left = mid + 1;
                else {
                    if (mid == a.length) {
                        //如果a全在里边
                        //p - mid >= a最后一个, 则成立
                        if (a[a.length - 1] <= b[p - mid]) return mid;
                        else right = mid - 1;
                    } else if (mid == 0) {
                        //若果a是0
                        if (a[0] >= b[p - mid - 1]) return mid;
                        else left = mid + 1;
                    } else {
                        if (p - mid == b.length) {
                            //如果b满了
                            if (a[mid] >= b[b.length - 1]) return mid;
                            else left = mid + 1;
                        } else if (p - mid == 0) {
                            //如果b是0
                            if (a[mid - 1] <= b[0]) return mid;
                            else right = mid - 1;
                        } else {
                            //如果两者都不是零且都不满
                            if (a[mid - 1] <= b[p - mid] && a[mid] >= b[p - mid - 1]) return mid;
                            else if (a[mid - 1] > b[p - mid]) right = mid - 1;
                            else left = mid + 1;
                        }
                    }
                }
            }
            return -1;
        }

        private double res(int[] a) {
            if (a.length % 2 == 1) return a[a.length / 2];
            else return (a[a.length / 2] + a[a.length / 2 - 1]) / 2.0;
        }

        public double findMedianSortedArrays(int[] a, int[] b) {
            if (a.length == 0 || b.length == 0) {
                return a.length == 0 ? res(b) : res(a);
            }
            //二分法, 以数组a在前半部分的个数
            int p = (a.length + b.length + 1) / 2;
            int m = findMid(a, b);
            //前p个中a有m个,b有p - m个
            if ((a.length + b.length) % 2 == 1) {
                return Math.max(m - 1 == -1 ? Integer.MIN_VALUE : a[m - 1], p - m - 1 == -1 ? Integer.MIN_VALUE : b[p - m - 1]);
            } else {
                int q = Math.max(m - 1 == -1 ? Integer.MIN_VALUE : a[m - 1], p - m - 1 == -1 ? Integer.MIN_VALUE : b[p - m - 1]);
                int h = Math.min(m == a.length ? Integer.MAX_VALUE : a[m], p - m == b.length ? Integer.MAX_VALUE : b[p - m]);
                return (q + h) / 2.0;
            }
        }
    }
}
