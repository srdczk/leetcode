package a0701_0800;

import java.util.TreeMap;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/30
 * @Description: a0701_0800
 * @version: 1.0
 */
public class A0732 {
    class MyCalendarThree {
        private TreeMap<Integer, Integer> map = new TreeMap<>();
        private int res = 0;
        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            int active = 0;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            for (int c : map.keySet()) {
                active += map.get(c);
                res = Math.max(active, res);
            }
            return res;
        }
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(start,end);
 */
}
