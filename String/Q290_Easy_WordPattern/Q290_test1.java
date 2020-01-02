import java.util.HashMap;

public class Q290_test1 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        int n = words.length;
        HashMap<Character, String> cToString = new HashMap<>();
        HashMap<String, Character> stringToC = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!cToString.containsKey(pattern.charAt(i)) && !stringToC.containsKey(words[i])) {
                cToString.put(pattern.charAt(i), words[i]);
                stringToC.put(words[i], pattern.charAt(i));
            } else if (cToString.containsKey(pattern.charAt(i)) && stringToC.containsKey(words[i]) &&
            cToString.get(pattern.charAt(i)).equals(words[i]) && stringToC.get(words[i]) == pattern.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Q290_test1().wordPattern("abba", "dog cat cat dog");
    }
}
