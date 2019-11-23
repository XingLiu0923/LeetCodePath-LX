import java.util.ArrayList;

public class Q129_test1 {
    private ArrayList<Integer> pathNumberList = new ArrayList<>();
    private int pathNumber = 0;

    public int sumNumbers(TreeNode root) {
        goAlongNumbers(root);
        int sum = 0;
        for (int each : pathNumberList) {
            sum += each;
        }
        return sum;
    }

    private void goAlongNumbers(TreeNode x) {
        if (x == null) return;
        pathNumber = pathNumber * 10 + x.val;
        if (x.left == null && x.right == null) {
            pathNumberList.add(pathNumber);
        }
        if (x.left != null) goAlongNumbers(x.left);
        if (x.right != null) goAlongNumbers(x.right);
        pathNumber /= 10;
    }
}
