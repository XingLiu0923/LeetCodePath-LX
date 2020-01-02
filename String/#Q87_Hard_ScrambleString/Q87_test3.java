import java.util.HashMap;

public class Q87_test3 {
    HashMap<String, Boolean> hm = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        String result = s1 + "#" + s2;
        if (hm.containsKey(result)) return hm.get(result);
        if (s1.length() != s2.length()) { hm.put(result, false); return false; }
        int n = s1.length();
        if (n == 1) { hm.put(result, s1.equals(s2)); return s1.equals(s2); }
        int[] letters = new int[26];
        for (int i = 0; i < n; i++) {
            letters[s1.charAt(i) - 'a']++;
        }
        for (int j = 0; j < n; j++) {
            letters[s2.charAt(j) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                hm.put(result, false); return false;
            }
        }
        for (int i = 1; i < n; i++) {
            String s1Left = s1.substring(0, i), s1Right = s1.substring(i, n);
            String s2Left = s2.substring(0, i), s2Right = s2.substring(i, n);
            String s2ReverseLeft = s2.substring(n - i, n), s2ReverseRight = s2.substring(0, n - i);
            if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)||
                    isScramble(s1Left, s2ReverseLeft) && isScramble(s1Right, s2ReverseRight)) {
                hm.put(result, true);
                return true;
            }
        }
        hm.put(result, false);
        return false;
    }
}
