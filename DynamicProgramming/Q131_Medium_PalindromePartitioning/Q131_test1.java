import java.util.ArrayList;
import java.util.List;

public class Q131_test1 {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        int n = s.length();
        if (n == 0) return lists;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                if (s.charAt(i) != s.charAt(i + gap)) dp[i][i + gap] = false;
                else {
                    if (gap == 1) dp[i][i + gap] = true;
                    else dp[i][i + gap] = dp[i + 1][i + gap - 1];
                }
            }
        }
        List<String> path = new ArrayList<>();
        partition(s, dp, path, lists, 0);
        return lists;
    }

    private void partition(String s, boolean[][] dp, List<String> path, List<List<String>> lists, int begin) {
        int n = s.length();
        if (begin >= n) {
            List<String> finalPath = new ArrayList<>();
            finalPath.addAll(path);
            lists.add(finalPath);
            return;
        }
        for (int end = begin; end < n; end++) {
            if (dp[begin][end]) {
                path.add(s.substring(begin, end + 1));
                partition(s, dp, path, lists, end + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Q131_test1().partition("abbab");
    }
}
