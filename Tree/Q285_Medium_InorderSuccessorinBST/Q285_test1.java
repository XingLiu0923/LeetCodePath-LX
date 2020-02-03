import java.util.Stack;

public class Q285_test1 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        while (x != p) {
            stack.push(x);
            if (x.val < p.val) x = x.right;
            else x = x.left;
        }
        if (p.right != null) {
            x = p.right;
            while (x.left != null) x = x.left;
            return x;
        } else {
            x = p;
            while (!stack.isEmpty() && x.val > stack.peek().val) {
                x = stack.pop();
            }
            if (stack.isEmpty()) return null;
            return stack.peek();
        }
    }
}