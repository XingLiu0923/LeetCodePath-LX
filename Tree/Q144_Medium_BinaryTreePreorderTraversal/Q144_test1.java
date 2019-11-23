import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144_test1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            list.add(root.val);
            if (root.right != null) s.push(root.right);
            if (root.left != null) s.push(root.left);
        }
        return list;
    }
}
