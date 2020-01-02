import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q127_test2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int[] clock = new int[n + 1];
        clock[n] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        wordList.add(beginWord);
        int endPos = -1;
        for (int i = 0; i < n; i++) {
            if (wordList.get(i).equals(endWord)) {
                endPos = i; break;
            }
        }
        if (endPos == -1) return 0;
        while (!q.isEmpty()) {
            int currPos = q.poll();
            int currClo = clock[currPos];
            for (int i = 0; i < n; i++) {
                if (clock[i] == 0 && isNext(wordList.get(currPos), wordList.get(i))) {
                    clock[i] = currClo + 1;
                    q.add(i);
                    if (i == endPos) return clock[i];
                }
            }
        }
        return 0;
    }

    private boolean isNext(String a, String b) {
        int n = a.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) sum++;
            if (sum > 1) return false;
        }
        return true;
    }
}
