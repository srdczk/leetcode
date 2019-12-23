package a0101_0200;

import java.util.*;

public class A0127 {
    class Solution {
        // 广度优先搜索
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            HashSet<String> wordSet = new HashSet<>(wordList);
            HashMap<String, Integer> map = new HashMap<>();
            if (!wordSet.contains(endWord)) return 0;
            if (beginWord.equals(endWord)) return 1;
            queue.offer(beginWord);
            map.put(beginWord, 1);
            while (!queue.isEmpty()) {
                String p = queue.poll();
                char[] chs = p.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (chs[i] == 'z') chs[i] = 'a';
                        else chs[i]++;
                        String s = new String(chs);
                        if (wordSet.contains(s)) {
                            if (!map.containsKey(s)) {
                                map.put(s, map.get(p) + 1);
                                queue.offer(s);
                            }
                            if (s.equals(endWord)) return map.get(p) + 1;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
