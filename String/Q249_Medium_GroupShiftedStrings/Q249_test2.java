import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q249_test2 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groupList = new ArrayList<>();
        int n = strings.length;
        Trie groupTrie = new Trie();
        for (int i = 0; i < n; i++) {
            int groupNum = groupTrie.contains(strings[i]);
            if (groupNum == -1) {
                List<String> group = new ArrayList<>();
                groupTrie.insert(strings[i]);
                group.add(strings[i]);
                groupList.add(group);
            } else {
                groupList.get(groupNum).add(strings[i]);
            }
        }
        return groupList;
    }

    class Trie {
        class Node {
            int groupNum;
            HashMap<Integer, Node> next;

            Node() {
                groupNum = -1;
                next = new HashMap<>();
            }
        }

        private Node root;
        private int size;

        Trie() {
            root = new Node();
            size = 0;
        }

        public int contains(String word) {
            int n = word.length();
            Node x = root;
            for (int i = 1; i < n; i++) {
                int gap = word.charAt(i) - word.charAt(i - 1);
                gap = gap < 0 ? gap + 26 : gap;
                if (!x.next.containsKey(gap)) return -1;
                x = x.next.get(gap);
            }
            return x.groupNum;
        }

        public int insert(String word) {
            int n = word.length();
            Node x = root;
            for (int i = 1; i < n; i++) {
                int gap = word.charAt(i) - word.charAt(i - 1);
                gap = (gap < 0) ? gap + 26 : gap;
                if (!x.next.containsKey(gap)) x.next.put(gap, new Node());
                x = x.next.get(gap);
            }
            x.groupNum = size++;
            return x.groupNum;
        }
    }
}
