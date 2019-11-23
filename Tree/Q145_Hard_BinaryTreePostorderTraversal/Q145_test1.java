import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_test1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        TreeNode x = root;
        Stack<TreeNode> s = new Stack<>();
        goToTheDeepest(x, s);
        while (!s.isEmpty()) {
            x = s.pop();
            arrayList.add(x.val);
            if (!s.isEmpty() && x == s.peek().left) goToTheDeepest(s.peek().right, s);
        }
        return arrayList;
    }

    private void goToTheDeepest(TreeNode x, Stack<TreeNode> s) {
        while (x != null) {
            s.push(x);
            if (x.left != null) x = x.left;
            else x = x.right;
        }
    }
}
