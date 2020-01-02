import java.util.*;

public class Q127_test3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dictionary = new HashMap<>();
        HashMap<String, List<String>> nbrDictionary = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            List<String> nbrWords = nbrString(word);
            nbrDictionary.put(word, nbrWords);
            for (String nbrWord : nbrWords) {
                ArrayList<String> nbrList = dictionary.containsKey(nbrWord) ? dictionary.get(nbrWord) : new ArrayList<>();
                nbrList.add(word);
                dictionary.put(nbrWord, nbrList);
            }
        }
        HashMap<String, Integer> clockSearch = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        clockSearch.put(beginWord, 1);
        while (!q.isEmpty()) {
            String currWord = q.poll();
            int clock = clockSearch.get(currWord);
            if (currWord.equals(endWord)) return clock;
            for (String nbrWord : nbrDictionary.get(currWord)) {
                for (String nextWord : dictionary.get(nbrWord)) {
                    if (!clockSearch.containsKey(nextWord)) {
                        clockSearch.put(nextWord, clock + 1);
                        q.add(nextWord);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> nbrString(String s) {
        int n = s.length();
        List<String> nbrS = new ArrayList<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char t = sChar[i];
            sChar[i] = '*';
            nbrS.add(String.valueOf(sChar));
            sChar[i] = t;
        }
        return nbrS;
    }

    public static void main(String[] args) {

    }
}
