import java.util.*;

public class Q272_test1 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> leftPart = new Stack<>();
        Queue<Integer> rightPart = new LinkedList<>();
        int lowerLimit = (int) target;
        Inorder(root, lowerLimit, leftPart, rightPart);
        List<Integer> result = new ArrayList<>();
        for (int count = 0; count < k; count++) {
            if (leftPart.isEmpty()) result.add(rightPart.poll());
            else if (rightPart.isEmpty()) result.add(leftPart.pop());
            else if (Math.abs(leftPart.peek() - target) < Math.abs(rightPart.peek() - target)) result.add(leftPart.pop());
            else result.add(rightPart.poll());
        }
        return result;
    }

    private void Inorder(TreeNode root, int target, Stack<Integer> leftPart, Queue<Integer> rightPart) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            goAlongVine(root, stack);
            if (stack.isEmpty()) break;
            root = stack.pop();
            if (root.val <= target) leftPart.push(root.val);
            else rightPart.add(root.val);
            root = root.right;
        }
    }

    private void goAlongVine(TreeNode x, Stack<TreeNode> stack) {
        while (x != null) {
            stack.push(x);
            x = x.left;
        }
    }

    public static void main(String[] args) {
        long a = (long) (Math.pow(2, 32) - Math.pow(2, 24) + Math.pow(2, 25) - 2);
        System.out.print(a);
    }
}
