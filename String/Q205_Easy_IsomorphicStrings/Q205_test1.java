import java.util.HashMap;

public class Q205_test1 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n == 0) return true;
        HashMap<Character, Character> hms = new HashMap<>();
        HashMap<Character, Character> hmt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hms.containsKey(s.charAt(i)) && !hmt.containsKey(t.charAt(i))) {
                hms.put(s.charAt(i), t.charAt(i));  hmt.put(t.charAt(i), s.charAt(i));
            } else if (hms.containsKey(s.charAt(i)) && hmt.containsKey(t.charAt(i)) &&
                    hms.get(s.charAt(i)) == t.charAt(i) && hmt.get(t.charAt(i)) == s.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
