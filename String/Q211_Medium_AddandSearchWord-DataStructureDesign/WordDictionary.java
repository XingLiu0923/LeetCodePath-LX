import java.util.HashMap;

class WordDictionary {

    private class Node {
        boolean isWord;
        HashMap<Character, Node> next;

        Node() {
            isWord = false;
            next = new HashMap<>();
        }

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }

    private Node root;
    int size;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        size = 0;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int n = word.length();
        Node x = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!x.next.containsKey(c)) x.next.put(c, new Node());
            x = x.next.get(c);
        }
        if (x.isWord) return;
        x.isWord = true; size++;
        return;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, Node x) {
        if (i == word.length()) return x.isWord;
        if (word.charAt(i) != '.' && !x.next.containsKey(word.charAt(i))) return false;
        if (word.charAt(i) == '.') {
            boolean result = false;
            for (char c = 'a'; c <= 'z'; c++) {
                if (x.next.containsKey(c)) result = result || search(word, i + 1, x.next.get(c));
            }
            return result;
        } else return search(word, i + 1, x.next.get(word.charAt(i)));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */