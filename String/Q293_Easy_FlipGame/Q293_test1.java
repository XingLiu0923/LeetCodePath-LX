import java.util.ArrayList;
import java.util.List;

public class Q293_test1 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> moveList = new ArrayList<>();
        int n = s.length();
        if (n == 0) return moveList;
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (chars[i] == '+' && chars[i - 1] == '+') {
                chars[i] = '-'; chars[i - 1] = '-';
                moveList.add(String.valueOf(chars));
                chars[i] = '+'; chars[i - 1] = '+';
            }
        }
        return moveList;
    }
}
