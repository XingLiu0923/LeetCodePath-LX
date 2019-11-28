import java.util.HashMap;
import java.util.Stack;

public class trie {
    private class Node {
        boolean isWord;
        HashMap<Character, Node> next;

        Node() {
            isWord = false;
            next = new HashMap<>();
        }

        Node(boolean isWord) {
            this.isWord = isWord;
        }
    }

    private Node root;
    private int size;

    public trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }



    public void add(String word) {
        int n = word.length();
        Node x = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!x.next.containsKey(c)) {
                x.next.put(c, new Node());
            }
            x = x.next.get(c);
        }
        if (!x.isWord) size++;
        x.isWord = true;
    }

    public boolean contains(String word) {
        int n = word.length();
        Node x = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!x.next.containsKey(c)) return false;
            x = x.next.get(c);
        }
        return x.isWord;
    }

    public boolean isPrefix(String prefix) {
        int n = prefix.length();
        Node x = root;
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (!x.next.containsKey(c)) return false;
            x = x.next.get(c);
        }
        return true;
    }

    public void delete(String word) {
        Stack<Node> s = new Stack<>();
        int n = word.length();
        Node x = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!x.next.containsKey(c)) return;
            s.push(x);
            x = x.next.get(c);
        }
        if (!x.isWord) return;
        size--;
        if (!x.next.isEmpty()) { x.isWord = false; return; }
        for (int i = n - 1; i > -1; i--) {
            char c = word.charAt(i);
            x = s.pop();
            if (x.isWord || x.next.size() > 1) { x.next.remove(c); return; }
            x.next.clear();
        }
    }
}
