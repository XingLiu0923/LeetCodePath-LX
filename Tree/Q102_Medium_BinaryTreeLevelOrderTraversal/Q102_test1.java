import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q102_test1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return (List)resultList;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> layerQueue = new LinkedList<>();
        nodeQueue.add(root);
        layerQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode x = nodeQueue.pop();
            int layer = layerQueue.pop();
            result.add(x.val);
            if (layerQueue.isEmpty() || layer != layerQueue.peek()) {
                resultList.add(result);
                result = new ArrayList<>();
            }
            if (x.left != null) { nodeQueue.add(x.left);  layerQueue.add(layer + 1); }
            if (x.right != null) { nodeQueue.add(x.right); layerQueue.add(layer + 1); }
        }
        return (List)resultList;
    }
}
