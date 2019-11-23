import java.util.*;

public class Q236_test1 {
    private List<List<TreeNode>> pathList = new ArrayList<>();
    private List<TreeNode> path = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        goAlongPath(root, p, q);
        int n = Math.min(pathList.get(0).size(), pathList.get(1).size());
        TreeNode ancestor = null;
        for (int i = 0; i < n; i++) {
            if (pathList.get(0).get(i).val == pathList.get(1).get(i).val) ancestor = pathList.get(0).get(i);
            else break;
        }
        return ancestor;
    }

    private void goAlongPath(TreeNode x, TreeNode p, TreeNode q) {
        if (x == null) return;
        path.add(x);
        if (x.val == p.val || x.val == q.val) {
            pathList.add(new ArrayList<>(path));
            if (pathList.size() == 2) return;
        }
        goAlongPath(x.left, p, q);
        goAlongPath(x.right, p, q);
        path.remove(path.size() - 1);
    }
}
