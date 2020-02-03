import java.util.HashMap;

public class Q159_test1 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int length = 0, maxLength = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int match = 0;
        while (right < n) {
            char c = s.charAt(right++);
            if (!window.containsKey(c)) window.put(c, 0);
            window.put(c, window.get(c) + 1);
            if (window.size() <= 2) {
                length = right - left;
                if (length > maxLength) maxLength = length;
            }
            while (window.size() > 2) {
                char cLeft = s.charAt(left);
                window.put(cLeft, window.get(cLeft) - 1);
                if (window.get(cLeft) == 0) window.remove(cLeft);
                left++;
            }
        }
        return maxLength;
    }
}
