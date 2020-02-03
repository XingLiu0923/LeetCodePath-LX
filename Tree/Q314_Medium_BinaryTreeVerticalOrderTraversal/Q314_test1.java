import java.util.*;

public class Q314_test1 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int[] minmax = new int[2];
        Queue<TreeNode> nodeQueue = new LinkedList<>(); Queue<Integer> levelQueue = new LinkedList<>();
        nodeQueue.add(root); levelQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode x = nodeQueue.poll();
            int curLevel = levelQueue.poll();
            if (!hashMap.containsKey(curLevel)) hashMap.put(curLevel, new ArrayList<>());
            hashMap.get(curLevel).add(x.val);
            minmax[0] = Math.min(minmax[0], curLevel); minmax[1] = Math.max(minmax[1], curLevel);
            if (x.left != null) { nodeQueue.add(x.left); levelQueue.add(curLevel - 1); }
            if (x.right != null) { nodeQueue.add(x.right); levelQueue.add(curLevel + 1); }
        }
        for (int i = minmax[0]; i <= minmax[1]; i++) {
            lists.add(hashMap.get(i));
        }
        return lists;
    }
}
