import java.util.Stack;

public class Q114_test2 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        stack.push(x);
        while (!stack.isEmpty()) {
            x = stack.pop();
            if (x.right != null) stack.push(x.right);
            if (x.left != null) stack.push(x.left);
            if (!stack.isEmpty()) x.right = stack.peek();
            x.left = null;
        }
    }
}
