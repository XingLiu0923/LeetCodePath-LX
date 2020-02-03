import java.util.ArrayList;
import java.util.List;

public class Q93_test2 {
    public List<String> restoreIpAddresses(String s) {
        List<String> pathList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            int na = Integer.valueOf(s.substring(0, a));
                            int nb = Integer.valueOf(s.substring(a, a + b ));
                            int nc = Integer.valueOf(s.substring(a + b, a + b + c));
                            int nd = Integer.valueOf(s.substring(a + b + c));
                            if (na <= 255 && nb <= 255 && nc <= 255 && nd <= 255) {
                                sb.append(na).append(".").append(nb).append(".").append(nc).append(".").append(nd);
                                if (sb.length() == s.length() + 3) pathList.add(sb.toString());
                                sb.delete(0, sb.length());
                            }
                        }
                    }
                }
            }
        }
        return pathList;
    }
}
