public class Q116_test1 {
    public Node connect(Node root) {
        if (root == null) return null;
        connect(root.left); connect(root.right);
        Node leftPath = root.left, rightPath = root.right;
        while (leftPath != null && rightPath != null) {
            leftPath.next = rightPath;
            leftPath = leftPath.right;
            rightPath = rightPath.left;
        }
        return root;
    }
}
