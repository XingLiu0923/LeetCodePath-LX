public class Q10_test1 {
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        boolean[][] dp = new boolean[np + 1][ns + 1];
        for (int j = 0; j < ns + 1; j++) {
            dp[0][j] = (j == 0);
        }
        for (int i = 1; i < np + 1; i++) {
            for (int j = 0; j < ns + 1; j++) {
                char matchC = p.charAt(i - 1);
                if (matchC >= 'a' && matchC <= 'z') dp[i][j] = (j > 0) && (matchC == s.charAt(j - 1) && dp[i - 1][j - 1]);
                else if (matchC == '.') dp[i][j] = j > 0 && dp[i - 1][j - 1];
                else {
                    if (i == 1) dp[i][j] = j == 0;      // 第一个就是'*'， 前面找不到和它匹配对元素；
                    else {
                        char matchCBefore = p.charAt(i - 2);
                        if (matchCBefore >= 'a' && matchCBefore <= 'z') {
                            if (j == 0 || s.charAt(j - 1) != matchCBefore) dp[i][j] = dp[i - 2][j];
                            else dp[i][j] = dp[i][j - 1] || dp[i - 2][j];
                        }
                        else if (matchCBefore == '*') dp[i][j] = dp[i - 1][j];
                        else {
                            if (j == 0) dp[i][j] = dp[i - 2][j];
                            else dp[i][j] = dp[i][j - 1] || dp[i - 2][j];
                        }
                    }
                }
            }
        }
        return dp[np][ns];
    }

    public static void main(String[] args) {
        new Q10_test1().isMatch("", ".*");
    }
}
