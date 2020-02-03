import java.util.ArrayList;
import java.util.List;

public class Q95_test1 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0) return list;
        if (n == 1) {
            list.add(new TreeNode(1));
            return list;
        }
        List<TreeNode> lastList = generateTrees(n - 1);
        for (TreeNode each : lastList) {
            TreeNode firstNode = new TreeNode(n);
            firstNode.left = each;
            list.add(firstNode);
            for (int i = 0; i < n; i++) {
                TreeNode copyNode = clone(each);
                TreeNode point = copyNode;
                int count = i;
                while (count > 0) {
                    if (point == null) break;
                    point = point.right;
                    count--;
                }
                if (point == null) break;
                TreeNode x = new TreeNode(n);
                x.left = point.right;
                point.right = x;
                list.add(copyNode);
            }
        }
        return list;
    }

    private TreeNode clone(TreeNode x) {
        if (x == null) return null;
        TreeNode newX = new TreeNode(x.val);
        newX.left = clone(x.left);
        newX.right = clone(x.right);
        return newX;
    }
}
