import java.util.Stack;

public class Q224_test1 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        s = s + "$";
        Integer num = null;
        int n = s.length();
        Stack<Integer> nS = new Stack<>();
        Stack<Character> opS = new Stack<>();
        opS.push('$');
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (num == null) num = 0;
                num = num * 10 + c - '0';
            }
            else {
                if (num != null) { nS.push(num); num = null; }
                if (c == '(') opS.push(c);
                else {
                    int currR = rank(c);
                    int lastR = rank(opS.peek());
                    if (currR <= lastR) {
                        char op = opS.pop(); if (op == '$') continue;
                        int b = nS.pop(), a = nS.pop();
                        nS.push(count(a, b, op));
                    }
                    if (c == ')') opS.pop();
                    else opS.push(c);
                }
            }
        }
        return nS.pop();
    }

    // 可以引起运算的东西才放到里面排序；
    private int rank(char c) {
        if (c == '+' || c == '-') return 0;
        if (c == ')') return -1;
        else return -2;
    }

    private int count(int a, int b, char c) {
        if (c == '+') return a + b;
        else return a - b;
    }

    public static void main(String[] args) {
        new Q224_test1().calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
