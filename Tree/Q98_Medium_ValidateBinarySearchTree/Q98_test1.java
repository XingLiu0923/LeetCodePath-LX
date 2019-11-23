import java.util.Stack;

public class Q98_test1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        int lastValue = Integer.MIN_VALUE;
        int count = 0;      // 防止第一个数为最小值；
        while (true) {
            count++;
            goAlongVine(s, root);
            if (s.isEmpty()) break;
            root = s.pop();
            if (count > 1 && root.val <= lastValue) return false;
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }

    private void goAlongVine(Stack<TreeNode> s, TreeNode x) {
        while (x != null) {
            s.push(x);
            x = x.left;
        }
    }
}
