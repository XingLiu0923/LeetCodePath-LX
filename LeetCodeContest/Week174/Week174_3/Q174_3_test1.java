import java.util.HashMap;

public class Q174_3_test1 {
    public int maxProduct(TreeNode root) {
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        countSum(root, hashMap);
        int max = 0;
        int wholeSum = hashMap.get(root);
        int gap = Integer.MAX_VALUE;
        for (TreeNode key : hashMap.keySet()) {
            int c = hashMap.get(key);
            if (Math.abs(wholeSum / 2 - c) < gap) {
                max = c;
                gap = Math.abs(wholeSum / 2 - c);
            }
        }
        long res = (long)max * (long)(wholeSum - max);
        return (int) (res % 1000000007);
    }

    private void countSum(TreeNode x, HashMap<TreeNode, Integer> hashMap) {
        if (x == null) return;
        int count = x.val;
        if (x.left != null) {
            countSum(x.left, hashMap);
            count += hashMap.get(x.left);
        }
        if (x.right != null) {
            countSum(x.right, hashMap);
            count += hashMap.get(x.right);
        }
        hashMap.put(x, count);
    }
}
