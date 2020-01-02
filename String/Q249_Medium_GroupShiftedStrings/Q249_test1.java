import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q249_test1 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groupLists = new ArrayList<>();
        if (strings.length == 0) return groupLists;
        int n = strings.length; Trie groupTrie = new Trie();
        for (int i = 0; i < n; i++) {
            int ListNumber = groupTrie.contains(strings[i]);
            if (ListNumber == -1) {
                groupTrie.insert(strings[i]);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(strings[i]);
                groupLists.add(newGroup);
            } else {
                groupLists.get(ListNumber).add(strings[i]);
            }
        }
        return groupLists;
    }

    private class Trie {
        class TrieNode {
            HashMap<Character, TrieNode> next;
            int listNumber;

            TrieNode() {
                next = new HashMap<>();
                listNumber = -1;
            }
        }

        TrieNode root;
        int size;

        Trie() {
            root = new TrieNode();
            size = 0;
        }

        public int contains(String word) {
            TrieNode x = root;
            for (char i = 'a'; i < 'z' + 1; i++) {
                if (x.next.containsKey(i)) {
                    int listNum = contains(x.next.get(i), i - word.charAt(0), word, 1);
                    if (listNum != -1) return listNum;
                }
            }
            return -1;
        }

        private int contains(TrieNode x, int gap, String word, int position) {
            if (position >= word.length()) return x.listNumber;
            char i = (char) ((word.charAt(position) + gap < 'a') ? (word.charAt(position) + gap + 26) : (word.charAt(position) + gap > 'z') ? (word.charAt(position) + gap - 26) : (word.charAt(position) + gap));
            if (!x.next.containsKey(i)) return -1;
            return contains(x.next.get(i), gap, word, position + 1);
        }

        public void insert(String word) {
            TrieNode x = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (!x.next.containsKey(c)) {
                    x.next.put(c, new TrieNode());
                }
                x = x.next.get(c);
            }
            x.listNumber = size;
            size++;
        }
    }
}
