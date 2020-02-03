public class Q270_test1 {
    public int closestValue(TreeNode root, double target) {
        if (root.val == target) return root.val;
        if (root.val < target) {
            if (root.right == null) return root.val;
            int rightV = closestValue(root.right, target);
            double distThis = Math.abs(target - root.val), distRight = Math.abs(target - rightV);
            if (distThis < distRight) return root.val;
            else return rightV;
        } else {
            if (root.left == null) return root.val;
            int leftV = closestValue(root.left, target);
            double distThis = Math.abs(target - root.val), distLeft = Math.abs(target - leftV);
            if (distThis < distLeft) return root.val;
            else return leftV;
        }
    }
}
