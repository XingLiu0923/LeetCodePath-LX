import java.util.ArrayList;
import java.util.List;

public class Q22_test1 {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n);
    }

    private List<String> generateParenthesis(int left, int right) {     // 剩下多少括号；
        List<String> list = new ArrayList<>();
        if (left > right || left < 0 || right < 0) return list;
        if (left == 0 && right == 0) {
            String s = "";
            list.add(s);
            return list;
        }
        List<String> list1 = generateParenthesis(left - 1, right);
        List<String> list2 = generateParenthesis(left, right - 1);
        for (String each : list1) {
            String newS = each + '(';
            list.add(newS);
        }
        for (String each : list2) {
            String newS = each + ')';
            list.add(newS);
        }
        return list;
    }

    public static void main(String[] args) {
        new Q22_test1().generateParenthesis(3);
    }
}
