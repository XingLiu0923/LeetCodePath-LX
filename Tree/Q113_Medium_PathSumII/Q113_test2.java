import java.util.ArrayList;
import java.util.List;

public class Q113_test2 {
    List<List<Integer>> pathList = new ArrayList<>();   // 记录所有的路径；
    List<Integer> path = new ArrayList<>();     // 记录走过的路径；利用回溯将每次符合要求的路径都放到pathList里面去；

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return pathList;
        path.add(root.val);     // 记录当前走的点；
        // 到尽头，则压入pathList中；
        if (root.left == null && root.right == null && root.val == sum) {
            pathList.add(new ArrayList<>(path));
        }
        // 未到尽头，讨论；
        if (root.left != null) pathSum(root.left, sum - root.val);      // 走左边的路径；
        if (root.right != null) pathSum(root.right, sum - root.val);        // 走右边的路径；
        path.remove(path.size() - 1);       // 包含当前点的路径已经走完，推出当前点；
        return pathList;
    }
}
