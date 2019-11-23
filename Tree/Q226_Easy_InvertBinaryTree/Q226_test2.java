import java.util.LinkedList;
import java.util.Queue;

public class Q226_test2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode x = q.remove();
            TreeNode t = x.left;
            x.left = x.right;
            x.right = t;
            if (x.left != null) q.add(x.left);
            if (x.right != null) q.add(x.right);
        }
        return root;
    }
}
