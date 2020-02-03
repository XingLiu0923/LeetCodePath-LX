import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94_test2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = root;
        while (true) {
            goAlongVine(x, stack);
            if (stack.isEmpty()) break;
            x = stack.pop();
            list.add(x.val);
            x = x.right;
        }
        return list;
    }

    protected void goAlongVine(TreeNode x, Stack<TreeNode> stack) {
        while (x != null) {
            stack.push(x);
            x = x.left;
        }
    }
}
