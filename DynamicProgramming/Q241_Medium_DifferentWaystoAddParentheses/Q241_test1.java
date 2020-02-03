import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Q241_test1 {
    public List<Integer> diffWaysToCompute(String input) {
        Vector<Integer> nums = new Vector<>();
        Vector<Character> op = new Vector<>();
        int n = input.length();
        int l = 0, m = 0;
        while (m < n) {
            while (m < n && input.charAt(m) >= '0' && input.charAt(m) <= '9') m++;
            nums.add(Integer.valueOf(input.substring(l, m)));
            if (m < n) op.add(input.charAt(m));
            l = m + 1; m = l;
        }
        int numLength = nums.size();
        List<Integer>[][] dp = new List[numLength][numLength];
        for (int i = 0; i < numLength; i++) {
            for (int j = 0; j < numLength; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < numLength; i++) dp[i][i].add(nums.get(i));
        for (int gap = 1; gap < numLength; gap++) {
            for (int i = 0; i + gap < numLength; i++) {
                for (int k = i; k + 1 <= i + gap; k++) {
                    for (Integer eachBefore : dp[i][k]) {
                        for (Integer eachNext : dp[k + 1][i + gap]) {
                            dp[i][i + gap].add(opon(eachBefore, eachNext, op.get(k)));
                        }
                    }
                }
            }
        }
        return dp[0][numLength - 1];
    }

    private int opon(int a, int b, char c) {
        if (c == '+') return a + b;
        else if (c == '-') return a - b;
        else return a * b;
    }
}
