package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson on 12/18/18.
 */
public class Concatenated_Words_472 {

    private TrieNode root;
    private List<String> result;

    private void addWord(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
        node.word = str;
    }


    public List<String> findAllConcatenateWordsInADict(String[] words) {
        root = new TrieNode();
        for (String str : words) {
            if (str.length() == 0) {
                continue;
            }
            addWord(str);
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }


    private void dfs(TrieNode node, int multi) {
        if (node.isEnd && !node.added && multi > 1) {
            node.combo = true;
            node.added = true;
            result.add(node.word);
        }
        searchWold(node, root, multi);
    }

    private void searchWold(TrieNode node1, TrieNode node2, int multi) {
        if (node2.combo) {
            return;
        }

        if (node2.isEnd) {
            dfs(node1, multi + 1);
        }

        for (int i = 0; i < 26; i++) {
            if (node1.children[i] != null && node2.children[i] != null) {
                searchWold(node1.children[i], node2.children[i], multi);
            }
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String word;
        public boolean isEnd;
        public boolean combo;
        public boolean added;

        public TrieNode() {
            this.word = new String();
            this.isEnd = false;
            this.combo = false;
            this.added = false;
        }
    }

//    public static void main(String[] args) {
//        Concatenated_Words_472 concatenated_words_472 = new Concatenated_Words_472();
//        concatenated_words_472.findAllConcatenateWordsInADict(new String[]{"a", "b"});
//    }
}




