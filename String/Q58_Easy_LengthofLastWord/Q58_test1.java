public class Q58_test1 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int i = n - 1;
        int sum = 0;
        while (i > -1) {
            if (s.charAt(i) == ' ') {
                if (sum != 0) break;
            } else {
                sum++;
            }
            i--;
        }
        return sum;
    }
}
