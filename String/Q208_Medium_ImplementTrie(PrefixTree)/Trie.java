import java.util.HashMap;

public class Trie {

    private class TrieNode {
        boolean isWord;
        HashMap<Character, TrieNode> next;

        TrieNode() {
            isWord = false;
            next = new HashMap<>();
        }

        TrieNode(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }

    TrieNode root;
    int size;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        TrieNode x = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!x.next.containsKey(c)) x.next.put(c, new TrieNode());
            x = x.next.get(c);
        }
        if (x.isWord) return;
        x.isWord = true; size++;
        return;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int n = word.length();
        TrieNode x = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!x.next.containsKey(c)) return false;
            x = x.next.get(c);
        }
        return x.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode x = root;
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (!x.next.containsKey(c)) return false;
            x = x.next.get(c);
        }
        return true;
    }
}
