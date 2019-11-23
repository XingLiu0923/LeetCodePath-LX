import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> s;
    TreeNode x;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        x = root;
    }

    private void goAlongVine(TreeNode node, Stack stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        goAlongVine(x, s);
        x = s.pop();
        int val = x.val;
        x = x.right;
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty() || x != null;
    }
}
