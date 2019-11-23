import java.util.Stack;

public class Q230_test1 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int kthsmallerst = 0;
        while (k > 0) {
            goAlongVine(root, s);
            if (s.isEmpty()) break;
            root = s.pop();
            kthsmallerst = root.val;
            root = root.right;
            k--;
        }
        return kthsmallerst;
    }

    private void goAlongVine(TreeNode x, Stack<TreeNode> s) {
        while (x != null) {
            s.push(x);
            x = x.left;
        }
    }
}
