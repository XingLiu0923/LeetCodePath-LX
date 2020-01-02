import java.util.Stack;

public class Q388_test1 {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) return 0;
        String[] inputPath = input.split("\n");
        int maxLength = 0, n = inputPath.length;
        int currLength = 0;
        Stack<String> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            int indent = indentNum(inputPath[i]);
            while (indent < s.size()) {
                currLength = currLength - s.pop().length() - 1;
                currLength = currLength < 0 ? 0 : currLength;
            }
            String tmps = inputPath[i].substring(indent);
            s.push(tmps);
            currLength = currLength > 0 ? currLength + tmps.length() + 1 : currLength + tmps.length();
            if (tmps.indexOf('.') != -1) maxLength = maxLength < currLength ? currLength : maxLength;
        }
        return maxLength;
    }

    private int indentNum(String input) {
        int num = 0, n = input.length();
        int i = 0;
        while (i < n) {
            if (input.charAt(i++) == '\t') num++;
            else break;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        new Q388_test1().lengthLongestPath(s);
    }
}
