import java.util.ArrayList;
import java.util.List;

public class Q282_test1 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0 || num == null) return res;
        dfs(res, num, target, "",0, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String num, int target, String path, int pos, long calcV, long prevNum) {
        if (pos == num.length()) {
            if (calcV == target) res.add(path);
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long curNum = Long.valueOf(num.substring(pos, i + 1));
            if (pos == 0) dfs(res, num, target, path + curNum, i + 1, calcV + curNum, curNum);
            else {
                dfs(res, num, target, path + "+" + curNum, i + 1, calcV + curNum, curNum);
                dfs(res, num, target, path + "-" + curNum, i + 1, calcV - curNum, -curNum);
                dfs(res, num, target, path + "*" + curNum, i + 1, calcV - prevNum + prevNum * curNum, prevNum * curNum);
            }
        }
    }
}
