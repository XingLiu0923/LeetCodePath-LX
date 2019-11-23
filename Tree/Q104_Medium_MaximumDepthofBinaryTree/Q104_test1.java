import java.util.LinkedList;
import java.util.Queue;

public class Q104_test1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> layerQueue = new LinkedList<>();
        nodeQueue.add(root);
        layerQueue.add(1);
        int layer = 1;
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.remove();
            layer = layerQueue.remove();
            if (root.left != null) { nodeQueue.add(root.left); layerQueue.add(layer + 1); }
            if (root.right != null) { nodeQueue.add(root.right); layerQueue.add(layer + 1); }
        }
        return layer;
    }
}
