import java.util.ArrayList;
import java.util.List;

public class Q89_test1 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) { list.add(0); return list; }
        List<Integer> lastList = grayCode(n - 1);
        list.addAll(lastList);
        int base = (int) Math.pow(2, n - 1);
        for (int i = lastList.size() - 1; i > -1; i--) {
            list.add(base + lastList.get(i));
        }
        return list;
    }
}
