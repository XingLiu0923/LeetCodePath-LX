
import java.util.HashSet;

public class Q3_test1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> hashSet = new HashSet<>();
        int maxLength = 0, length = 0;
        int i = 0, j = 0;
        while (j < n) {
            char c = s.charAt(j);
            while (hashSet.contains(c)) {
                hashSet.remove(s.charAt(i++));
                length--;
            }
            hashSet.add(c); length++; j++;
            if (length > maxLength) maxLength = length;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new Q3_test1().lengthOfLongestSubstring("pwwkew");
    }
}
