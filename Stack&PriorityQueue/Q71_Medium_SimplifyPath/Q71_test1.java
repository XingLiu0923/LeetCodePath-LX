import java.util.Stack;

public class Q71_test1 {
    public String simplifyPath(String path) {
        Stack<Character> absolutePath = new Stack<>();
        absolutePath.push('/');
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (absolutePath.peek() == '/') continue;
                else if (absolutePath.peek() == '.') {
                    int count = 0;
                    while (absolutePath.peek() == '.') { absolutePath.pop(); count++; }
                    if (count == 2) {
                        if (absolutePath.size() > 1) {
                            absolutePath.pop();
                            while (absolutePath.peek() != '/') absolutePath.pop();
                        }
                    } else if (count > 2) {
                        while (count-- > 0) absolutePath.push('.');
                    }
                }
                else absolutePath.push('/');
            } else if (path.charAt(i) == '.') {
                absolutePath.push('.');
            } else absolutePath.push(path.charAt(i));
        }
        while (absolutePath.size() > 1 && absolutePath.peek() == '/') absolutePath.pop();
        int count = 0;
        while (absolutePath.size() > 1 && (absolutePath.peek() == '.')) {
            if (absolutePath.peek() == '.') count++;
            absolutePath.pop();
        }
        if (count == 2) {
            if (absolutePath.size() > 1) absolutePath.pop();
            while (absolutePath.size() > 1 && absolutePath.peek() != '/') absolutePath.pop();
            if (absolutePath.size() > 1) absolutePath.pop();
        } else if (count > 2){
            while (count-- > 0) absolutePath.push('.');
        }
        while (absolutePath.size() > 1 && absolutePath.peek() == '/') absolutePath.pop();
        char[] ap = new char[absolutePath.size()];
        for (int i = absolutePath.size() - 1; i > -1; i--) {
            ap[i] = absolutePath.pop();
        }
        return String.valueOf(ap);
    }
}
