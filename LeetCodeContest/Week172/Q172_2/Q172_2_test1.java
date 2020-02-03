import java.util.ArrayList;
import java.util.List;

public class Q172_2_test1 {
    public List<String> printVertically(String s) {
        String[] ss = s.split(" ");
        int maxL = 0;
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            if (ss[i].length() > maxL) maxL = ss[i].length();
        }
        StringBuilder[] sbs = new StringBuilder[maxL];
        for (int i = 0; i < maxL; i++) sbs[i] = new StringBuilder();
        for (int i = 0; i < maxL; i++) {
            for (int j = 0; j < n; j++) {
                if (i > ss[j].length() - 1) sbs[i].append(" ");
                else sbs[i].append(ss[j].charAt(i));
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxL; i++) {
            String st = sbs[i].toString();
            int stn = st.length();
            int j = stn - 1;
            while (j > -1 && st.charAt(j) == ' ') j--;
            st = st.substring(0, j + 1);
            list.add(st);
        }
        return list;
    }
}
