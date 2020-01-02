import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q127_test1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(beginWord, 1);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll();
            int clock = hashMap.get(word);
            for (String each : wordList) {
                if (!hashMap.containsKey(each) && isNext(word, each)) {
                    hashMap.put(each, clock + 1);
                    q.add(each);
                }
            }
            if (hashMap.containsKey(endWord)) return hashMap.get(endWord);
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
