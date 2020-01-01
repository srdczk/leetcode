package a0701_0800;

import java.util.ArrayList;
import java.util.List;

public class A0745 {

    class WordFilter {

        private class TrieNode {
            List<Integer> pass = new ArrayList<>();
            TrieNode[] next = new TrieNode[26];
        }
        private class Trie {
            TrieNode root = new TrieNode();

            public void insert(String s, int k) {
                TrieNode node = root;
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    if (node.next[chs[i] - 'a'] == null) node.next[chs[i] - 'a'] = new TrieNode();
                    node = node.next[chs[i] - 'a'];
                    node.pass.add(k);
                }
            }

            private List<Integer> search(String s) {
                TrieNode node = root;
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    if (node.next[chs[i] - 'a'] == null) return new ArrayList<>();
                    node = node.next[chs[i] - 'a'];
                }
                return node.pass;
            }

        }

        private Trie preTrie = new Trie(), sufTrie = new Trie();

        private int max;

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                preTrie.insert(words[i], i);
                sufTrie.insert(new StringBuilder(words[i]).reverse().toString(), i);
            }
            max = words.length - 1;
        }

        public int f(String prefix, String suffix) {
            List<Integer> preList = preTrie.search(prefix),
                    sufList = sufTrie.search(new StringBuilder(suffix).reverse().toString());
            if (prefix.equals("") && suffix.equals("")) {
                return max;
            } else if (prefix.equals("")) {
                return sufList.size() == 0 ? -1 : sufList.get(sufList.size() - 1);
            } else if (suffix.equals("")) {
                return preList.size() == 0 ? -1 : preList.get(preList.size() - 1);
            }
            for (int i = preList.size() - 1; i > -1; i--) {
                if (sufList.contains(preList.get(i))) return preList.get(i);
            }
            return -1;
        }
    }
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
