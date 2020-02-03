import java.util.HashMap;
import java.util.HashSet;

public class Q76_test1 {
    public String minWindow(String s, String t) {
        int nt = t.length();
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < nt; i++) {
            char c = t.charAt(i);
            if (!dic.containsKey(c)) dic.put(c, 0);
            dic.put(c, dic.get(c) + 1);
        }
        int n = s.length();
        HashMap<Character, Integer> timesMap = new HashMap<>();
        int i = 0;
        int begin = 0, end = 0;
        int length = 0, minLength = Integer.MAX_VALUE;
        HashSet<Character> hashSet = new HashSet<>();
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (!dic.containsKey(s.charAt(i))) { i++; }
            if (dic.containsKey(c)) {
                if (!timesMap.containsKey(c)) timesMap.put(c, 0);
                timesMap.put(c, timesMap.get(c) + 1);
                if (timesMap.get(c) >= dic.get(c)) hashSet.add(c);
                if (hashSet.size() >= dic.size()) {
                    length = j - i + 1;
                    if (length < minLength) {
                        minLength = length;
                        begin = i;
                        end = j;
                    }
                }
                while (!dic.containsKey(s.charAt(i)) || timesMap.get(s.charAt(i)) > dic.get(s.charAt(i))) {
                    if (dic.containsKey(s.charAt(i))) timesMap.put(s.charAt(i), timesMap.get(s.charAt(i)) - 1);
                    i++;
                }
                if (hashSet.size() >= dic.size()) {
                    length = j - i + 1;
                    if (length < minLength) {
                        minLength = length;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        if (hashSet.size() < dic.size()) return "";
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        new Q76_test1().minWindow("cabefgecdaecf", "cae");
    }
}
