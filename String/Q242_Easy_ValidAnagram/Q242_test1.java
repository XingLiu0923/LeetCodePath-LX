public class Q242_test1 {
    public boolean isAnagram(String s, String t) {
        int[] mark = new int[26];
        if (s.length() != t.length()) return false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            mark[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (mark[t.charAt(i) - 'a']-- <= 0) return false;
        }
        return true;
    }
}
