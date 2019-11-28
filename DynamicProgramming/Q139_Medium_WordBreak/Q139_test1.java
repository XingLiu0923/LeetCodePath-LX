import java.util.List;

public class Q139_test1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];      // dp[i]代表前i个是可以match的
        for (int i = 0; i < n; i++) {
            dp[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {
                if (dp[i] == true) break;
                if (i - word.length() < -1) continue;
                if (i - word.length() == -1) {
                     if (s.substring(0, i + 1).matches(word))
                         dp[i] = true;
                }
                else dp[i] = dp[i - word.length()] && s.substring(i - word.length() + 1, i + 1).matches(word);
            }
        }
        return dp[n - 1];
    }

}
