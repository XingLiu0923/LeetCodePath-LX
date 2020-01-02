import java.util.Stack;

public class Q227_test1 {
    public int calculate(String s) {
        s = s.replace(" ", "");
        s = s + "#";
        Stack<Integer> numS = new Stack<>();
        Stack<Character> opS = new Stack<>();
        opS.push('#');
        int n = s.length(); Integer curNum = null;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (curNum == null) curNum = 0;
                curNum = curNum * 10 + c - '0';
            } else {
                if (curNum != null) { numS.push(curNum); curNum = null; }
                int currOpRank = opRank(c);
                int lastOpRank = opRank(opS.peek());
                while (currOpRank <= lastOpRank) {
                    char lastOp = opS.pop();    if (lastOp == '#') break;
                    int cN = numS.pop(), lN = numS.pop();
                    numS.push(count(lN, cN, lastOp));
                    lastOpRank = opRank(opS.peek());
                }
                opS.push(c);
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
        else return a / b;
    }

    public static void main(String[] args) {
        System.out.println(new Q227_test1().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
