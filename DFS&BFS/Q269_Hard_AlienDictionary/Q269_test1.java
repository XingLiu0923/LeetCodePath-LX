import java.util.HashSet;
import java.util.Stack;

public class Q269_test1 {
    private enum VStatus {
        UNDISCOVERED, DISCOVERED, VISITED
    }

    public String alienOrder(String[] words) {
        HashSet<Integer>[] wordsSequence = new HashSet[26];
        boolean[] contains = new boolean[26];
        for (int i = 0; i < 26; i++) wordsSequence[i] = new HashSet<>();
        int n = words.length;
        if (n == 1) return words[0];
        char[][] wordsChar = new char[n][];
        for (int i = 0; i < n; i++) {
            wordsChar[i] = words[i].toCharArray();
        }
        for (int i = 0; i < n - 1; i++) {
            boolean mark = false;
            int maxL = Math.max(wordsChar[i].length, wordsChar[i + 1].length);
            for (int j = 0; j < maxL; j++) {
                if (!mark) {
                    if (j >= wordsChar[i + 1].length) return "";
                    if (j < wordsChar[i].length) contains[wordsChar[i][j] - 'a'] = true;
                    if (j < wordsChar[i + 1].length) contains[wordsChar[i + 1][j] - 'a'] = true;
                    if (j < wordsChar[i].length && j < wordsChar[i + 1].length && wordsChar[i][j] != wordsChar[i + 1][j]) {
                        wordsSequence[wordsChar[i][j] - 'a'].add(wordsChar[i + 1][j] - 'a');
                        mark = true;
                    }
                } else {
                    if (j < wordsChar[i].length) contains[wordsChar[i][j] - 'a'] = true;
                    if (j < wordsChar[i + 1].length) contains[wordsChar[i + 1][j] - 'a'] = true;
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        VStatus[] status = new VStatus[26];
        for (int i = 0; i < 26; i++) {
            status[i] = VStatus.UNDISCOVERED;
        }
        for (int i = 0; i < 26; i++) {
            if (!wordsSequence[i].isEmpty() && status[i] == VStatus.UNDISCOVERED) {
                if (!dfs(i, wordsSequence, status, stack, contains)) return "";
            }
        }
        String s = "";
        while (!stack.isEmpty()) s += stack.pop();
        for (int i = 0; i < 26; i++) {
            if (contains[i]) s += (char) (i + 'a');
        }
        return s;
    }

    private boolean dfs(int i, HashSet<Integer>[] wordsSequence, VStatus[] status, Stack<Character> stack, boolean[] mark) {
        status[i] = VStatus.DISCOVERED;
        mark[i] = false;
        for (int each : wordsSequence[i]) {
            if (status[each] == VStatus.DISCOVERED) return false;
            if (status[each] == VStatus.UNDISCOVERED) {
                if (!dfs(each, wordsSequence, status, stack, mark)) return false;
            }
        }
        stack.push((char) (i + 'a'));
        status[i] = VStatus.VISITED;
        return true;
    }

    public static void main(String[] args) {
        new Q269_test1().alienOrder(new String[] {"wrt","wrf","er","ett","rftt"});
    }
}
