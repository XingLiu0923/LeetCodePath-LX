import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q337_test1 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int robIncludeRoot = MaxRobInclude(root);
        int robExcludeRoot = MaxRboExclude(root);
        return Math.max(robIncludeRoot, robExcludeRoot);
    }

    private int MaxRobInclude(TreeNode x) {
        if (x == null) return 0;
        return MaxRboExclude(x.left) + MaxRboExclude(x.right) + x.val;
    }

    private int MaxRboExclude(TreeNode x) {
        if (x == null) return 0;
        int MaxLcInclude = MaxRobInclude(x.left), MaxLcExclude = MaxRboExclude(x.left);
        int MaxRcInclude = MaxRobInclude(x.right), MaxRcExclude = MaxRboExclude(x.right);
        return Math.max(MaxLcExclude + MaxRcExclude, Math.max(MaxLcExclude + MaxRcInclude, Math.max(MaxLcInclude + MaxRcExclude, MaxLcInclude + MaxRcInclude)));
    }
}
