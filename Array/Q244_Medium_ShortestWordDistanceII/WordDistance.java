import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {

    HashMap<String, List<Integer>> hashMap;

    public WordDistance(String[] words) {
        hashMap = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(words[i])) hashMap.put(words[i], new ArrayList<>());
            hashMap.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = hashMap.get(word1);
        List<Integer> list2 = hashMap.get(word2);
        int i = 0, j = 0;
        int minDist = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int dist = Math.abs(list1.get(i) - list2.get(j));
            minDist = dist < minDist ? dist : minDist;
            if (i >= list1.size() - 1) j++;
            else if (j >= list2.size() - 1) i++;
            else if (list2.get(j) < list1.get(i)) j++;
            else i++;
        }
        return minDist;
    }

    public static void main(String[] args) {
        String[] s = {"a", "a", "b", "b"};
        new WordDistance(s).shortest("a", "b");
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */