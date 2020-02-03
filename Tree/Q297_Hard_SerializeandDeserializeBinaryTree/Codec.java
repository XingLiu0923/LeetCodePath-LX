import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int height = getHeight(root);
        if (height == 0) return " ";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> heightQ = new LinkedList<>();
        heightQ.add(height);
        nodeQ.add(root);
        while (!nodeQ.isEmpty()) {
            TreeNode x = nodeQ.poll();
            int curHieght = heightQ.poll();
            if (x == null) {
                sb.append("null ");
            } else {
                sb.append(x.val + " ");
                if (x.left != null || x.right != null || curHieght > 1) {
                    nodeQ.add(x.left); nodeQ.add(x.right);
                    heightQ.add(curHieght - 1); heightQ.add(curHieght - 1);
                }
            }
        }
        return sb.toString().trim();
    }

    private int getHeight(TreeNode x) {
        if (x == null) return 0;
        return 1 + Math.max(getHeight(x.left), getHeight(x.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(" ");
        int n = ss.length;
        if (n == 0) return null;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(ss[0]));
        nodeQueue.add(root);
        int i = 1;
        while (i < n) {
            TreeNode x = nodeQueue.poll();
            if (!ss[i].equals("null")) {
                TreeNode leftc = new TreeNode(Integer.valueOf(ss[i]));
                x.left = leftc;
                nodeQueue.add(x.left);
            }
            i++;
            if (!ss[i].equals("null")) {
                TreeNode rightc = new TreeNode(Integer.valueOf(ss[i]));
                x.right = rightc;
                nodeQueue.add(x.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));