import java.util.HashMap;
import java.util.Stack;

public class Q106_test1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) hashMap.put(inorder[i], i);
        return buildTree(inorder, -1, n - 1, postorder, -1, n - 1, hashMap);
    }

    private TreeNode buildTree(int[] inorder, int in_lo, int in_hi, int[] postorder, int post_lo, int post_hi, HashMap<Integer, Integer> hashMap) {
        if (in_lo >= in_hi || post_lo >= post_hi) return null;
        TreeNode x = new TreeNode(postorder[post_hi]);
        int posX = hashMap.get(postorder[post_hi]);
        int dist = in_hi - posX;
        x.right = buildTree(inorder, posX, in_hi, postorder, post_hi - dist - 1, post_hi - 1, hashMap);
        x.left = buildTree(inorder, in_lo, posX - 1, postorder, post_lo, posX - 1 - in_lo + post_lo, hashMap);
        return x;
    }
}
