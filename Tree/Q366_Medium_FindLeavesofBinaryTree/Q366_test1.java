import java.util.ArrayList;
import java.util.List;

public class Q366_test1 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> newList = new ArrayList<>();
        if (root == null) return newList;
        List<List<Integer>> leftList = findLeaves(root.left);
        List<List<Integer>> rightList = findLeaves(root.right);
        while (!leftList.isEmpty() || !rightList.isEmpty()) {
            List<Integer> leftLeaf = leftList.isEmpty() ? null : leftList.remove(0);
            List<Integer> rightLeaf = rightList.isEmpty() ? null : rightList.remove(0);
            if (leftLeaf == null) newList.add(rightLeaf);
            else if (rightLeaf == null) newList.add(leftLeaf);
            else {
                leftLeaf.addAll(rightLeaf);
                newList.add(leftLeaf);
            }
        }
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        newList.add(rootList);
        return newList;
    }
}
