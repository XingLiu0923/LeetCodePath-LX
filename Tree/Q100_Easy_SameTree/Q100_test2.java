import java.util.LinkedList;
import java.util.Queue;

public class Q100_test2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!checkPQ(p, q)) return false;
        if (p == null && q == null) return true;
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);  qQueue.add(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            p = pQueue.remove();    q = qQueue.remove();
            if (!checkPQ(p, q)) return false;
            if (p.left != null && q.left != null) { pQueue.add(p.left); qQueue.add(q.left); }
            if ((p.left == null && q.left != null) || (p.left != null) && q.left == null) return false;
            if (p.right != null && q.right != null) { pQueue.add(p.right); qQueue.add(q.right); }
            if ((p.right == null && q.right != null) || (p.right != null && q.right == null)) return false;
        }
        if ((pQueue.isEmpty() && !qQueue.isEmpty()) || (!pQueue.isEmpty() && qQueue.isEmpty())) return false;
        return true;
    }

    private boolean checkPQ(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return true;
        return false;
    }
}
