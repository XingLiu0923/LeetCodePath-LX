import java.util.ArrayList;
import java.util.List;

public class Q87_test1 {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int n = s1.length();
        List<Integer> cutP = findCutPoint(s1, s2);
        while (!cutP.isEmpty()) {
            int cutPoint = cutP.get(0);
            if (isScramble(s1.substring(0, cutPoint + 1), s2.substring(0, cutPoint + 1)) &&
                    isScramble(s1.substring(cutPoint + 1, n), s2.substring(cutPoint + 1, n))) return true;
            cutP.remove(0);
        }
        s2 = reverse(s2);
        cutP = findCutPoint(s1, s2);
        while (!cutP.isEmpty()) {
            int cutPoint = cutP.get(0);
            if (isScramble(s1.substring(0, cutPoint + 1), s2.substring(0, cutPoint + 1)) &&
                    isScramble(s1.substring(cutPoint + 1, n), s2.substring(cutPoint + 1, n))) return true;
            cutP.remove(0);
        }
        return false;
    }

    private List<Integer> findCutPoint(String s1, String s2) {
        int n = s1.length();
        List<Integer> cutPList = new ArrayList<>();
        boolean mark = false;
        for (int i = 0; i < n - 1; i++) {
            int[] alphaBet = new int[26];
            for (int j = 0; j <= i; j++) {
                alphaBet[s1.charAt(j) - 'a']++;
            }
            for (int j = 0; j <= i; j++) {
                if (alphaBet[s2.charAt(j) - 'a'] <= 0) {
                    mark = true; break;
                }
                alphaBet[s2.charAt(j) - 'a']--;
            }
            if (!mark) cutPList.add(i);
            mark = false;
        }
        return cutPList;
    }

    private String reverse(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n / 2; i++) {
            char t = cs[i];
            cs[i] = cs[n - 1 - i];
            cs[n - 1 - i] = t;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        new Q87_test1().isScramble("ab", "aa");
    }
}
