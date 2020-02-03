import java.util.LinkedList;
import java.util.Queue;

public class Q5_test1 {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chars = new char[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            if (i % 2 == 0) chars[i] = '#';
            else chars[i] = s.charAt(i / 2);
        }
        Queue<Integer> centerQ = new LinkedList<>();
        int maxLength = 0, finalCenter = 0;
        for (int i = 0; i < 2 * n + 1; i++) {
            centerQ.add(i);
            int centerN = centerQ.size();
            while (centerN-- > 0) {
                int center = centerQ.poll(), centerL = centerLength(chars, center, i);
                if (centerL > 0) {
                    centerQ.add(center);
                    if (centerL > maxLength) { maxLength = centerL; finalCenter = center; }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = finalCenter - maxLength/2; i < finalCenter + maxLength/2; i++) {
            if (chars[i] != '#') sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int centerLength(char[] chars, int center, int i) {
        int j = 2 * center - i;
        if (j < 0 || chars[i] != chars[j]) return 0;
        return 2 * (i - center) + 1;
    }
}
