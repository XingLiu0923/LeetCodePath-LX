import java.util.ArrayList;
import java.util.List;

public class Q113_test1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (root == null) return pathList;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> thisPath = new ArrayList<>();
            thisPath.add(root.val);
            pathList.add(thisPath);
        }
        if (root.left != null) {
            for (List each : pathSum(root.left, sum - root.val)) {
                List<Integer> thisPath = new ArrayList<>();
                thisPath.add(root.val);
                thisPath.addAll(each);
                pathList.add(thisPath);
            }
        }
        if (root.right != null) {
            for (List each : pathSum(root.right, sum - root.val)) {
                List<Integer> thisPath = new ArrayList<>();
                thisPath.add(root.val);
                thisPath.addAll(each);
                pathList.add(thisPath);
            }
        }
        return pathList;
    }
}
