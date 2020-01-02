import java.util.Stack;

public class Q150_test1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) numbers.push(numbers.pop() + numbers.pop());
            else if (tokens[i].equals("-")) numbers.push(- numbers.pop() + numbers.pop());
            else if (tokens[i].equals("*")) numbers.push(numbers.pop() * numbers.pop());
            else if (tokens[i].equals("/")) {
                int devidor = numbers.pop();
                int devidend = numbers.pop();
                numbers.push(devidend / devidor);
            }
            else numbers.push(Integer.valueOf(tokens[i]));
        }
        return numbers.peek();
    }
}
