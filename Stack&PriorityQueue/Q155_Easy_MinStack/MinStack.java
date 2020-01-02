import java.util.Stack;

class MinStack {
    Stack<Integer> minS;
    Stack<Integer> s;

    /** initialize your data structure here. */
    public MinStack() {
        minS = new Stack<>();
        s = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if (minS.isEmpty() || x <= minS.peek()) minS.push(x);
    }

    public void pop() {
        if (s.pop().intValue() == minS.peek().intValue()) minS.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024);
        s.push(512);
        s.pop();
        s.pop();
        s.pop();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */