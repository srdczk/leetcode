package a0701_0800;

import java.util.ArrayList;
import java.util.List;

public class A0722 {
    class Solution {
        public List<String> removeComments(String[] source) {
            StringBuilder sb = new StringBuilder();
            for (String s : source) {
                sb.append(s).append('\n');
            }
            while (sb.indexOf("/*") != -1 || sb.indexOf("//") != -1) {
                int a = sb.indexOf("/*");
                int b = sb.indexOf("//");
                if ((a == -1 && b != -1) || (a != -1 && b != -1 && b < a)) {
                    // 如果 只有 //, 则删除到其第一个 \n;
                    int index = sb.indexOf("\n", b);
                    sb.delete(b, index);
                } else {
                    int index = sb.indexOf("*/", a + 2);
                    sb.delete(a, index + 2);
                }
            }
            String[] res = sb.toString().split("\n");
            List<String> list = new ArrayList<>();
            for (String s : res) {
                if (s.length() > 0) list.add(s);
            }
            return list;
        }
    }
}
