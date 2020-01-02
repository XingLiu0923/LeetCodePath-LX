import java.util.HashMap;

public class Q294_test2 {
    private HashMap<String, Boolean> hm = new HashMap<>();

    public boolean canWin(String s) {
        int n = s.length();
        if (n == 0) return false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String anotherS = s.substring(0, i - 1) + "--" + s.substring(i + 1, n);
                if (hm.containsKey(anotherS) && !hm.get(anotherS)) { hm.put(s, true); return true; }
                else if (hm.containsKey(anotherS) && hm.get(anotherS)) { hm.put(s, false); }
                else if (!canWin(anotherS)) { hm.put(s, true); return true; }
                else hm.put(s, false);
            }
        }
        return false;
    }
}
