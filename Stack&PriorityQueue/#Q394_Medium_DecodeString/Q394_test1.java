import java.util.Stack;
import java.util.Vector;

public class Q394_test1 {
    public String decodeString(String s) {
        Stack<Integer> numS = new Stack<>();
        Stack<Character> charS = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '1' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (i < n - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') sb.append(s.charAt(++i));
                numS.push(Integer.valueOf(sb.toString()));
            }
            else if (c == ']') {
                Vector<Character> cVec = new Vector<>();
                while (charS.peek() != '[') cVec.add(charS.pop());
                charS.pop();
                int num = numS.pop();
                while (num-- > 0) {
                    for (int j = cVec.size() - 1; j > -1; j--) {
                        charS.push(cVec.get(j));
                    }
                }
            } else charS.push(c);
        }
        Stack<Character> tmps = new Stack<>();
        while (!charS.isEmpty()) {
            tmps.push(charS.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!tmps.isEmpty()) sb.append(tmps.pop());
        return sb.toString();
    }
}
