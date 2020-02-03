public class Q117_test1 {
    public Node connect(Node root) {
        if (root == null) return null;
        connect(root.left); connect(root.right);
        Node leftPath = root.left, rightPath = root.right;
        while (leftPath != null && rightPath != null) {
            while (leftPath.left == null && leftPath.right == null && leftPath.next != null) {
                leftPath = leftPath.next;
            }
            Node leftT = leftPath;
            while (leftT.next != null) leftT = leftT.next;
            leftT.next = rightPath;
            while (rightPath.left == null && rightPath.right == null && rightPath.next != null) {
                rightPath = rightPath.next;
            }
            if (leftPath.left != null) leftPath = leftPath.left;
            else leftPath = leftPath.right;
            if (rightPath.left != null) rightPath = rightPath.left;
            else rightPath = rightPath.right;
        }
        return root;
    }
}
