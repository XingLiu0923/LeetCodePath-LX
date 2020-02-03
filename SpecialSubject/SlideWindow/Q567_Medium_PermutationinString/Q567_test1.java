import java.util.HashMap;

public class Q567_test1 {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            if (!hashMap1.containsKey(c)) hashMap1.put(c, 0);
            hashMap1.put(c, hashMap1.get(c) + 1);
        }
        int n2 = s2.length();
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int mark = 0;
        while (right < n2) {
            char c = s2.charAt(right);
            if (!hashMap1.containsKey(c)) { right++; continue; }
            if (!window.containsKey(c)) window.put(c, 0);
            window.put(c, window.get(c) + 1);
            if (window.get(c).intValue() == hashMap1.get(c).intValue()) mark++;
            right++;
            while (mark == hashMap1.size()) {
                if (right - left == n1) return true;
                char cLeft = s2.charAt(left);
                if (!hashMap1.containsKey(cLeft)) { left++; continue; }
                window.put(cLeft, window.get(cLeft) - 1);
                if (window.get(cLeft).intValue() < hashMap1.get(cLeft)) mark--;
                left++;
            }
        }
        return false;
    }
}
