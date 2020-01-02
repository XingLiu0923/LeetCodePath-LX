import java.util.Stack;

public class Q772_test1 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        s = s + "#";
        Integer num = null;
        int n = s.length();
        Stack<Integer> numS = new Stack<>();
        Stack<Character> opS = new Stack<>();
        opS.push('#');
        numS.push(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (num == null) num = 0;
                num = num * 10 + c - '0';
            } else {
                if (c == '-' && i > 0 && s.charAt(i - 1) == '(') numS.push(0);
                if (num != null) { numS.push(num); num = null; }
                if (c != '(') {
                    int currOpRank = opRank(c);
                    int lastOpRand = opRank(opS.peek());
                    while (currOpRank <= lastOpRand) {
                        char lastOp = opS.pop();
                        if (lastOp == '(' || lastOp == '#') break;
                        int curN = numS.pop(), lastN = numS.pop();
                        numS.push(count(lastN, curN, lastOp));
                        lastOpRand = opRank(opS.peek());
                    }
                }
                if (c != ')') opS.push(c);
            }
        }
        return numS.pop();
    }

    private int opRank(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else return 0;
    }

    private int count(int a, int b, char c) {
        if (c == '+') return a + b;
        if (c == '-') return a - b;
        if (c == '*') return a * b;
        if (c == '/') return a / b;
        else return 0;
    }

    public static void main(String[] args) {
        new Q772_test1().calculate("( 4   +  (   (  (   5+ 4)-( 7  -   9  )  ) -( 10 +(   9+ 8 )  )) )");
    }
}
