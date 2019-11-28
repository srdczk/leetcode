package a0201_0300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A0212 {
    // 遍历每一个, 在Trie中搜索
    class Solution {
        private class TrieNode {
            public int p, e;
            public TrieNode[] next;
            public TrieNode() {
                p = 0;
                e = 0;
                next = new TrieNode[26];
            }
        }
        private class Trie {
            public TrieNode root = new TrieNode();
            public void insert(String s) {
                TrieNode node = root;
                node.p++;
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    if (node.next[chs[i] - 'a'] == null) {
                        node.next[chs[i] - 'a'] = new TrieNode();
                    }
                    node = node.next[chs[i] - 'a'];
                    node.p++;
                }
                node.e++;
            }
        }
        private char[][] a;
        private Set<String> res = new HashSet<>();
        private Trie trie = new Trie();
        private int[] x = {0, 0, 1, -1}, y = {1, -1, 0, 0};
        private void dfs(StringBuilder sb, int i, int j, TrieNode node) {
            if (node.e > 0) res.add(sb.toString());
            for (int k = 0; k < 4; k++) {
                int tx = x[k] + i, ty = y[k] + j;
                if (tx > -1 && tx < a.length && ty > -1 && ty < a[0].length && a[tx][ty] >= 'a' && a[tx][ty] <= 'z' && node.next[a[tx][ty] - 'a'] != null) {
                    int len = sb.length();
                    sb.append(a[tx][ty]);
                    char tmp = a[i][j];
                    a[i][j] = '#';
                    dfs(sb, tx, ty, node.next[a[tx][ty] - 'a']);
                    sb.setLength(len);
                    a[i][j] = tmp;
                }
            }
        }

        public List<String> findWords(char[][] c, String[] words) {
            a = c;
            for (String word : words) trie.insert(word);
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    if (trie.root.next[a[i][j] - 'a'] != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a[i][j]);
                        dfs(sb, i, j, trie.root.next[a[i][j] - 'a']);
                    }
                }
            }
            return new ArrayList<>(res);
        }
    }
}
