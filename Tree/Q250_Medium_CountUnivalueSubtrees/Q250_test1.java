import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q250_test1 {

    private int sum = 0;

    public int countUnivalSubtrees(TreeNode root) {
        goAlongTree(root);
        return sum;
    }

    private boolean goAlongTree(TreeNode x) {
        if (x == null) return true;
        boolean isLeft = goAlongTree(x.left);
        boolean isRight = goAlongTree(x.right);
        if (isLeft && isRight) {
            if ((x.left != null && x.left.val != x.val) || (x.right != null && x.right.val != x.val)) return false;
            sum++;
            return true;
        }
        return false;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Q250_test1().countUnivalSubtrees(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
