import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Q107_test2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return levelList;
        levelOrderBottom(root, levelList, 1);
        Collections.reverse(levelList);
        return levelList;
    }

    private void levelOrderBottom(TreeNode x, List<List<Integer>> levelList, int depth) {
        if (x == null) return;
        if (depth > levelList.size()) levelList.add(new ArrayList<Integer>());
        levelList.get(depth - 1).add(x.val);
        levelOrderBottom(x.left, levelList, depth + 1);
        levelOrderBottom(x.right, levelList, depth + 1);
    }
}
