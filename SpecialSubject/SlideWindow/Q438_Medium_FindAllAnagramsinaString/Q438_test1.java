import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q438_test1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int np = p.length();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < np; i++) {
            if (!needs.containsKey(p.charAt(i))) needs.put(p.charAt(i), 0);
            needs.put(p.charAt(i), needs.get(p.charAt(i)) + 1);
        }
        int ns = s.length();
        int left = 0, right = 0;
        int match = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < ns) {
            char c = s.charAt(right);
            if (!needs.containsKey(c)) { right++; continue; }
            if (!window.containsKey(c)) window.put(c, 0);
            window.put(c, window.get(c) + 1);
            if (window.get(c).intValue() == needs.get(c).intValue()) match++;
            right++;
            while (match == needs.size()) {
                if (right - left == np) list.add(left);
                char cLeft = s.charAt(left);
                if (window.containsKey(cLeft)) {
                    window.put(cLeft, window.get(cLeft) - 1);
                    if (window.get(cLeft) < needs.get(cLeft)) match--;
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Q438_test1().findAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
