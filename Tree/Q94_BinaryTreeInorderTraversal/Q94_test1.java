import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94_test1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        TreeNode x = root;
        Stack<TreeNode> s = new Stack<>();
        while (true) {
            goAlongVine(x, s);
            if (s.isEmpty()) break;
            x = s.pop();
            arrayList.add(x.val);
            x = x.right;
        }
        return arrayList;
    }

    private void goAlongVine(TreeNode x, Stack<TreeNode> s) {
        while (x != null) {
            s.push(x);
            x = x.left;
        }
    }
}
