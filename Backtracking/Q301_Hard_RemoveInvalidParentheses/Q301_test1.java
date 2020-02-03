import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q301_test1 {
    public List<String> removeInvalidParentheses(String s) {
        int leftParen = 0, rightParen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') leftParen++;
            else if (c == ')') {
                if (leftParen > 0) leftParen--;
                else rightParen++;
            }
        }
        // 此时得出了多出来的leftp和rightp的个数
        List<String> list = new ArrayList<>();
        String path = "";
        HashSet<String> hashSet = new HashSet<>();
        dfs(s, 0, path, hashSet, 0, leftParen, 0, rightParen, 0);
        for (String each : hashSet) list.add(each);
        return list;
    }

    private void dfs(String s, int i, String path, HashSet<String> hashSet, int leftRemove, int leftLimit, int rightRemove, int rightLimit, int leftRetain) {
        if (i == s.length()) {
            if (leftRemove == leftLimit && rightRemove == rightLimit) hashSet.add(path);
            return;
        }
        char c = s.charAt(i);
        if (c != '(' && c != ')') dfs(s, i + 1, path + c, hashSet, leftRemove, leftLimit, rightRemove, rightLimit, leftRetain);
        else if (c == '(') {
            if (leftRemove < leftLimit) dfs(s, i + 1, path, hashSet, leftRemove + 1, leftLimit, rightRemove, rightLimit, leftRetain);
            dfs(s, i + 1, path + c, hashSet, leftRemove, leftLimit, rightRemove, rightLimit, leftRetain + 1);
        } else {
            if (leftRetain > 0) dfs(s, i + 1, path + c, hashSet, leftRemove, leftLimit, rightRemove, rightLimit, leftRetain - 1);
            if (rightRemove < rightLimit) dfs(s, i + 1, path, hashSet, leftRemove, leftLimit, rightRemove + 1, rightLimit, leftRetain);
        }
    }
}
