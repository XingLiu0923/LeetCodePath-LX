import java.util.HashMap;
import java.util.HashSet;

public class Q76_test2 {
    public String minWindow(String s, String t) {
        int nt = t.length();
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < nt; i++) {
            char c = t.charAt(i);
            if (!dic.containsKey(c)) dic.put(c, 0);
            dic.put(c, dic.get(c) + 1);
        }
        HashMap<Character, Integer> timesMap = new HashMap<>();
        int match = 0;
        int left = 0;
        int n = s.length();
        int begin = 0, end = 0;
        int length = 0, minLength = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (!dic.containsKey(c)) continue;
            if (!timesMap.containsKey(c)) timesMap.put(c, 0);
            timesMap.put(c, timesMap.get(c) + 1);
            if (timesMap.get(c) == dic.get(c)) match++;
            while (match == dic.size()) {
                char cLeft = s.charAt(left);
                length = right - left + 1;
                if (length < minLength) { begin = left; end = right; minLength = length; }
                if (!dic.containsKey(cLeft)) { left++; continue; }
                int leftTime = timesMap.get(cLeft) - 1;
                timesMap.put(cLeft, leftTime);
                if (leftTime < dic.get(cLeft)) match--;
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        // new Q76_test2().minWindow(s1, s2);
    }
}
