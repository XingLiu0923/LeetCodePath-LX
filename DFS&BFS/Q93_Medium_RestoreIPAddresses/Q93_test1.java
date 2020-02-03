import java.util.ArrayList;
import java.util.List;

public class Q93_test1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> pathList = new ArrayList<>();
        String path = "";
        restoreIpAddresses(s, 0, 3, pathList, path);
        return pathList;
    }

    private void restoreIpAddresses(String s, int begin, int leftPoint, List<String> pathList, String path) {
        int n = s.length();
        if (leftPoint == 0) {
            if (begin >= n || (s.charAt(begin) == '0' && begin != n - 1) || n - begin > 3 || Integer.valueOf(s.substring(begin, n)).intValue() > 255) return;
            pathList.add(path + s.substring(begin, n));
            return;
        }
        if (begin >= n - 1) return;
        if (s.charAt(begin) == '0') {
            restoreIpAddresses(s, begin + 1, leftPoint - 1, pathList, path + "0.");
            return;
        }
        for (int i = 1; i < 4; i++) {
            int end = begin + i;
            if (end > n) return;
            String subS = s.substring(begin, begin + i);
            if (Integer.valueOf(subS).intValue() > 255) return;
            restoreIpAddresses(s, end, leftPoint - 1, pathList, path + subS + ".");
        }
    }
}
