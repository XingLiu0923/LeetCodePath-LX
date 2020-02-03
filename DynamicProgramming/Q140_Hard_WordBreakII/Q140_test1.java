import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q140_test1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String> sentences = new ArrayList<>();
        if (n == 0) return sentences;
        List<Integer>[] dp = new List[n];
        for (int i = 0; i < n; i++) dp[i] = new ArrayList<>();
        boolean[] mark = new boolean[n + 1];
        mark[0] = true;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) return sentences;
            if (mark[i]) {
                for (String each : wordDict) {
                    int length = each.length();
                    if (i + length <= n && s.substring(i, i + length).equals(each)) {
                        mark[i + length] = true;
                        max = Math.max(i + length, max);
                        dp[i].add(length);
                    }
                }
            }
        }
        if (!mark[n]) return sentences;
        String sentence = "";
        wordBreak(s, dp, sentence, sentences, 0);
        return sentences;
    }

    private void wordBreak(String s, List<Integer>[] dp, String sentence, List<String> sentences, int begin) {
        int n = s.length();
        if (begin >= n) {
            sentences.add(sentence.trim());
            return;
        }
        for (int eachL : dp[begin]) {
            wordBreak(s, dp, sentence + " " + s.substring(begin, begin + eachL), sentences, begin + eachL);
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat"); list.add("cats"); list.add("and"); list.add("sand"); list.add("dog");
        new Q140_test1().wordBreak(s, list);
    }
}