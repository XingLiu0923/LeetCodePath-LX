import java.util.List;

public class Q139_test2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = -1; j < i; j++) {
                dp[i] = (j < 0) ? wordDict.contains(s.substring(j + 1, i + 1)) : (dp[j] && wordDict.contains(s.substring(j + 1, i + 1)));
                if (dp[i] == true) break;
            }
        }
        return dp[n - 1];
    }
}
