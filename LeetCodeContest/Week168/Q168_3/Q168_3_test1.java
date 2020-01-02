import java.util.Hashtable;

public class Q168_3_test1 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        int n = s.length();
        for (int size = minSize; size <= maxSize; size++) {
            int[] dictionary = new int[26];
            int diff = 0;
            for (int i = 0; i < size; i++) {
                if (dictionary[s.charAt(i) - 'a'] == 0) diff++;
                dictionary[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i + size <= n; i++) {
                if (diff <= maxLetters) {
                    String subS = s.substring(i, i + size);
                    if (!hashtable.containsKey(subS)) hashtable.put(subS, 1);
                    else hashtable.put(subS, hashtable.get(subS) + 1);
                }
                char c = s.charAt(i);
                dictionary[c - 'a']--;
                if (dictionary[c - 'a'] == 0) diff--;
                if (i + size < n) {
                    c = s.charAt(i + size);
                    if (dictionary[c - 'a'] == 0) diff++;
                    dictionary[c - 'a']++;
                }
            }
        }
        int max = 0;
        for (String key : hashtable.keySet()) {
            int count = hashtable.get(key);
            if (count > max) max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "babcbceccaaacddbdaedbadcddcbdbcbaaddbcabcccbacebda";
        new Q168_3_test1().maxFreq(s, 1, 1, 1);
    }
}
