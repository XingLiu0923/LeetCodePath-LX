import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q257_test1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        if (root == null) return pathList;
        Stack<String> pathStack = new Stack<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode x = s.pop();
            String lastPath = pathStack.isEmpty() ? "" : pathStack.pop();
            if (x.left != null) { s.push(x.left); pathStack.push(lastPath + x.val + "->"); }
            if (x.right != null) { s.push(x.right); pathStack.push(lastPath + x.val + "->"); }
            if (x.left == null && x.right == null) { pathList.add(lastPath + x.val); }
        }
        return pathList;
    }

    public static void main(String[] args) {
        Stack<int[]> s = new Stack<>();
        int[] a = {1, 2};
        s.push(a);
        int[] b = s.peek();
        b[1] = 3;
        int[] c = s.pop();
        for (int each : c) {
            System.out.println(each);
        }
    }
}
