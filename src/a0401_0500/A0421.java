package a0401_0500;

public class A0421 {
    // 构建前缀树求解
    class Solution {
        private class TrieNode {
            TrieNode x, y;
        }
        private class Trie {
            TrieNode root = new TrieNode();
            public void insert(int a) {
                TrieNode node = root;
                for (int i = 31; i > -1; i--) {
                    if (((a >> i) & 1) > 0) {
                        if (node.y == null) node.y = new TrieNode();
                        node = node.y;
                    } else {
                        if (node.x == null) node.x = new TrieNode();
                        node = node.x;
                    }
                }
            }
        }
        public int findMaximumXOR(int[] a) {
            Trie trie = new Trie();
            int res = 0;
            for (int c : a) {
                trie.insert(c);
                int k = 0;
                TrieNode node = trie.root;
                for (int i = 31; i > -1; i--) {
                    int p = (c >> i) & 1;
                    if (p > 0) {
                        if (node.x != null) {
                            k |= (1 << i);
                            node = node.x;
                        } else {
                            node = node.y;
                        }
                    } else {
                        if (node.y != null) {
                            k |= (1 << i);
                            node = node.y;
                        } else {
                            node = node.x;
                        }
                    }
                }
                res = Math.max(res, k);
            }
            return res;
        }
    }
}