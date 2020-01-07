package a1101_1200;
// Created by srdczk on 2020/1/7

import java.util.ArrayList;
import java.util.List;

public class A1104 {
    class Solution {
        private long level(long label) {
            // 查找 在第几层
            long left = 0, right = 20, lastPos = -1;
            while (left <= right) {
                long mid = left + ((right - left) >> 1);
                if (label > Math.pow(2, mid) - 1) {
                    lastPos = mid;
                    left = mid + 1;
                } else right = mid - 1;
            }
            return lastPos;
        }
        private long encode(long level, long label) {
            if (level % 2 == 1) {
                // 本应该 所在 的位置
                return (long) (3 * Math.pow(2, level) - 1 - label);
            } else return label;
        }
        //        private long encode(long level, long label) {
//            if (level % 2 == 1) {
//                // 所在的位置 存放的节点
//
//            } else return label;
//        }
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> res = new ArrayList<>();
            long level = level(label);
            label = (int) encode(level, label);
            while (level > -1) {
                res.add(0, (int) encode(level--, label));
                label /= 2;
            }
            return res;
        }
    }
}
