import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q103_test1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (root == null) return pathList;
        Stack<TreeNode> oddLine = new Stack<>();
        Stack<TreeNode> evenLine = new Stack<>();
        List<Integer> path = new ArrayList<>();
        boolean odd = true;
        oddLine.push(root);
        while (!oddLine.isEmpty() || !evenLine.isEmpty()) {
            if (odd) {
                root = oddLine.pop();
                path.add(root.val);
                if (root.left != null) evenLine.add(root.left);
                if (root.right != null) evenLine.add(root.right);
                if (oddLine.isEmpty()) {
                    pathList.add(new ArrayList<>(path));
                    path.clear();
                    odd = !odd;
                }
            } else {
                root = evenLine.pop();
                path.add(root.val);
                if (root.right != null) oddLine.add(root.right);
                if (root.left != null) oddLine.add(root.left);
                if (evenLine.isEmpty()) {
                    pathList.add(new ArrayList<>(path));
                    path.clear();
                    odd = !odd;
                }
            }
        }
        return pathList;
    }
}
