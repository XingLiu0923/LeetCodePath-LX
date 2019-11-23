import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q107_test1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return levelList;
        Stack<List<Integer>> levelStack = new Stack<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> layerQueue = new LinkedList<>();
        nodeQueue.add(root);
        layerQueue.add(1);
        int layer = 1;
        int lastLayer = 1;
        List<Integer> level = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.remove();
            layer = layerQueue.remove();
            if (!level.isEmpty() && layer != lastLayer) {
                levelStack.push(new ArrayList<>(level));
                level.clear();
            }
            lastLayer = layer;
            level.add(root.val);
            if (root.left != null) { nodeQueue.add(root.left); layerQueue.add(layer + 1); }
            if (root.right != null) { nodeQueue.add(root.right); layerQueue.add(layer + 1); }
        }
        levelStack.push(new ArrayList<>(level));
        while (!levelStack.isEmpty()) levelList.add(levelStack.pop());
        return levelList;
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> ret = new Q107_test1().levelOrderBottom(root);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
