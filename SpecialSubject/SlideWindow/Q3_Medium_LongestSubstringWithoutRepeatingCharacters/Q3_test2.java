import java.util.HashMap;

public class Q3_test2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hashMap = new HashMap();
        int i = 0, j = 0;
        int length = 0, maxLength = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (hashMap.containsKey(c)) i = Math.max(i, hashMap.get(c) + 1);
            hashMap.put(c, j);
            length = j - i + 1;
            maxLength = Math.max(length, maxLength);
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new Q3_test2().lengthOfLongestSubstring("pwwkew");
    }
}
