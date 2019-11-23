import java.util.ArrayList;
import java.util.List;

public class Q257_test2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> listPath = new ArrayList<>();
        if (root == null) return listPath;
        String thisPath = root.val + "->";
        if (root.left == null && root.right == null) { listPath.add(String.valueOf(root.val)); }
        if (root.left != null) {
            for (String each : binaryTreePaths(root.left)) {
                listPath.add(thisPath + each);
            }
        }
        if (root.right != null) {
            for (String each : binaryTreePaths(root.right)) {
                listPath.add(thisPath + each);
            }
        }
        return listPath;
    }
}
