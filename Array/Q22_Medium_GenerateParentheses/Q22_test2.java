import java.util.ArrayList;
import java.util.List;

public class Q22_test2 {
    public List<String> generateParenthesis(int n) {
        String s = "";
        List<String> result = new ArrayList<>();
        generateParenthesis(s, result, n, n);
        return result;
    }

    private void generateParenthesis(String s, List<String> result, int left, int right) {
        if (left == 0 && right == 0) { result.add(s); return; }
        if (left > right) return;
        if (left > 0) generateParenthesis(s + '(', result, left - 1, right);
        if (right > 0) generateParenthesis(s + ')', result, left, right - 1);
    }


    public static void main(String[] args) {
        new Q22_test2().generateParenthesis(2);
    }
}
