package a0701_0800;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/30
 * @Description: a0701_0800
 * @version: 1.0
 */
public class A0731 {
    class MyCalendarTwo {


        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            int active = 0;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            for (int c : map.keySet()) {
                active += map.get(c);
                if (active > 2) {
                    // 还原现场
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
