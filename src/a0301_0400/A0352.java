package a0301_0400;

import javafx.scene.chart.ValueAxis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/29
 * @Description: a0301_0400
 * @version: 1.0
 */
public class A0352 {
    class SummaryRanges {
        private class Node {
            int x, y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        private List<Node> list = new ArrayList<>();
        /** Initialize your data structure here. */
        public SummaryRanges() {

        }

        public void addNum(int val) {
            if (list.isEmpty()) {
                list.add(new Node(val, val));
                return;
            }
            int left = 0, right = list.size() - 1, lastPos = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (val >= list.get(mid).y) {
                    lastPos = mid;
                    left = mid + 1;
                } else right = mid - 1;
            }
            // 没有 >= y 的
            if (lastPos == -1) {
                // 则 判断第一个
                if (list.get(0).x == val + 1) list.get(0).x--;
                else if (list.get(0).x > val) list.add(0, new Node(val, val));
            } else {
                if (list.get(lastPos).y != val) {
                    if (lastPos == list.size() - 1) {
                        if (val == list.get(lastPos).y + 1) list.get(lastPos).y++;
                        else list.add(new Node(val, val));
                    } else {
                        if (val < list.get(lastPos + 1).x) {
                            if (val == list.get(lastPos + 1).x - 1 && val == list.get(lastPos).y + 1) {
                                Node node = new Node(list.get(lastPos).x, list.get(lastPos + 1).y);
                                list.remove(lastPos);
                                list.set(lastPos, node);
                            } else if (val == list.get(lastPos + 1).x - 1) {
                                list.get(lastPos + 1).x--;
                            } else if (val == list.get(lastPos).y + 1) {
                                list.get(lastPos).y++;
                            } else {
                                list.add(lastPos + 1, new Node(val, val));
                            }
                        }
                    }
                }
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0] = list.get(i).x;
                res[i][1] = list.get(i).y;
            }
            return res;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
}
