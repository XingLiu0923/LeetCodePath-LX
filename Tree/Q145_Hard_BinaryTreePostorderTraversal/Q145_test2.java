import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_test2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        goAlongVine(root, stack);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (!stack.isEmpty() && stack.peek().left == root) goAlongVine(stack.peek().right, stack);
        }
        return list;
    }

    private void goAlongVine(TreeNode x, Stack<TreeNode> stack) {
        while (x != null) {
            stack.push(x);
            if (x.left != null) x = x.left;
            else x = x.right;
        }
    }
}
