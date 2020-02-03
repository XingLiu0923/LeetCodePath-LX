import java.util.Stack;

public class Q99_test1 {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode hot = null;
        TreeNode small = null;
        boolean mark = false;
        while (true) {
            goAlongVine(root, stack);
            if (stack.isEmpty()) break;
            root = stack.pop();
            if (!mark) {
                if (hot != null && hot.val > root.val) {
                    mark = true;
                    small = root;
                } else {
                    hot = root;
                }
            } else {
                if (root.val < small.val) small = root;
            }
            root = root.right;
        }
        int t = hot.val;
        hot.val = small.val;
        small.val = t;
    }

    private void goAlongVine(TreeNode x, Stack<TreeNode> stack) {
        while (x != null) {
            stack.push(x);
            x = x.left;
        }
    }
}
