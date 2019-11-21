package a0201_0300;

public class A0208 {
    class Trie {
        private class TrieNode {
            public int p, e;
            public TrieNode[] next;
            public TrieNode() {
                p = 0;
                e = 0;
                next = new TrieNode[26];
            }
        }
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (node.next[chs[i] - 'a'] == null) node.next[chs[i] - 'a'] = new TrieNode();
                node = node.next[chs[i] - 'a'];
                node.p++;
            }
            node.e++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (node.next[chs[i] - 'a'] == null) return false;
                node = node.next[chs[i] - 'a'];
            }
            return node.e > 0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            char[] chs = prefix.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (node.next[chs[i] - 'a'] == null) return false;
                node = node.next[chs[i] - 'a'];
            }
            return node.p > 0;
        }
    }
}
