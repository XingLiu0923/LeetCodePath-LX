public class Q32_test1 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') dp[i] = i;
            else {
                int j = i - 1;
                while (j > -1 && dp[j] != j) {
                    j = dp[j] - 1;
                }
                if (j == -1 || s.charAt(j) == ')') dp[i] = i;
                else dp[i] = j;
            }
        }
        int maxLength = 0;
        int i = n - 1;
        while (i > -1) {
            int length = 0;
            while (i > 0 && dp[i] != i) {
                length += (i - dp[i] + 1);
                i = dp[i] - 1;
            }
            if (length > maxLength) maxLength = length;
            i--;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new Q32_test1().longestValidParentheses(")()())");
    }
}
