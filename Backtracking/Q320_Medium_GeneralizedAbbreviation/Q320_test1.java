import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q320_test1 {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        int n = word.length();
        if (n == 0) {
            list.add("");
            return list;
        }
        // String path = "";
        StringBuilder path = new StringBuilder();
        dfs(0, word, path, list, false);
        dfs(0, word, path, list, true);
        return list;
    }

    private void dfs(int begin, String word, StringBuilder path, List<String> hashSet, boolean marker) {
        int n = word.length();
        if (begin == n) { hashSet.add(path.toString()); return; }
        for (int i = begin; i < n; i++) {
            if (marker) dfs(i + 1, word, path.append(word.substring(begin, i + 1)), hashSet, !marker);
            if (!marker) dfs(i + 1, word, path.append(String.valueOf(i + 1 - begin)), hashSet, !marker);
            if (path.length() > 0) path.delete(begin, path.length());
        }
    }
}
