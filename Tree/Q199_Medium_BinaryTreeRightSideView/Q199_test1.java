import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_test1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();
        if (root == null) return rightList;
        Queue<TreeNode> nodeQueue = new LinkedList<>(); nodeQueue.add(root);
        Queue<Integer> layerQueue = new LinkedList<>(); layerQueue.add(1);
        int layer = 1;
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.remove();
            layer = layerQueue.remove();
            if (root.left != null) { nodeQueue.add(root.left); layerQueue.add(layer + 1); }
            if (root.right != null) { nodeQueue.add(root.right); layerQueue.add(layer + 1); }
            if (layerQueue.isEmpty() || layer != layerQueue.peek()) rightList.add(root.val);
        }
        return rightList;
    }
}
