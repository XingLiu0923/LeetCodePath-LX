import java.util.Stack;

public class Q394_test2 {
    public String decodeString(String s) {
        int num = 0; String res = "";
        Stack<Integer> nS = new Stack<>();
        Stack<String> sS = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c != '[' && c != ']') res = res + c;
            else {
                if (c == '[') {
                    nS.push(num);
                    sS.push(res);
                } else {
                    String lastS = "";
                    if (!sS.isEmpty()) lastS = sS.pop();
                    int lastN = 0;
                    if (!nS.isEmpty()) lastN = nS.pop();
                    while (lastN-- > 0) {
                        lastS = lastS + res;
                    }
                    res = lastS;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Q394_test2().decodeString("3[a]2[b4[F]c]");
    }
}
