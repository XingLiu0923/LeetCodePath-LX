import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q212_test2 {
    List<String> wordsList;
    StringBuilder wordsPath;

    public List<String> findWords(char[][] board, String[] words) {
        wordsList = new ArrayList<>();
        int n = words.length;
        if (n == 0) return wordsList;
        Trie wordsTrie = new Trie();
        for (String each : words) wordsTrie.insert(each);
        findWords(board, wordsTrie);
        return wordsList;
    }

    private void findWords(char[][] board, Trie wordsTrie) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] mark = new boolean[m][n];
                wordsPath = new StringBuilder();
                findWords(board, i, j, wordsTrie.root(), mark);
            }
        }
    }

    private void findWords(char[][] board, int i, int j, Trie.Node x, boolean[][] mark) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || mark[i][j]) return;
        if (!x.next.containsKey(board[i][j])) return;
        x = x.next.get(board[i][j]);
        wordsPath.append(board[i][j]);
        mark[i][j] = true;
        if (x.isWord && !x.inTheList) { String s = wordsPath.toString(); wordsList.add(s); x.inTheList = true; }
        int m = board.length, n = board[0].length;
        findWords(board, i - 1, j, x, mark);
        findWords(board, i + 1, j, x, mark);
        findWords(board, i, j - 1, x, mark);
        findWords(board, i, j + 1, x, mark);
        mark[i][j] = false;
        wordsPath.deleteCharAt(wordsPath.length() - 1);
    }

    class Trie {
        class Node {
            boolean isWord;
            boolean inTheList;
            HashMap<Character, Node> next;

            Node() {
                isWord = false;
                inTheList = false;
                next = new HashMap<>();
            }
        }

        private Node root;
        private int size;

        Trie() {
            root = new Node();
            size = 0;
        }

        public Node root() {
            return root;
        }

        public void insert(String word) {
            int n = word.length();
            Node x = root;
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if (!x.next.containsKey(c)) x.next.put(c, new Node());
                x = x.next.get(c);
            }
            if (x.isWord) return;
            x.isWord = true;
            size++;
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
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        board[0][0] = 'o'; board[0][1] = 'a'; board[0][2] = 'a'; board[0][3] = 'n';
        board[1][0] = 'e'; board[1][1] = 't'; board[1][2] = 'a'; board[1][3] = 'e';
        board[2][0] = 'i'; board[2][1] = 'h'; board[2][2] = 'k'; board[2][3] = 'r';
        board[3][0] = 'i'; board[3][1] = 'f'; board[3][2] = 'l'; board[3][3] = 'v';

        String[] words = {"oath","pea","eat","rain"};

        new Q212_test2().findWords(board, words);
    }
}
