import java.util.ArrayList;
import java.util.List;

public class Q77_test1 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combineList = new ArrayList<>();
        if (k == 0 || n < k) {
            List<Integer> tmp = new ArrayList<>();
            combineList.add(tmp);
            return combineList;
        }
        if (n == k) {
            List<Integer> combine = new ArrayList<>();
            for (int i = 1; i < k + 1; i++) {
                combine.add(i);
            }
            combineList.add(combine);
            return combineList;
        }
        for (List<Integer> each : combine(n - 1, k - 1)) {
            each.add(n);
            combineList.add(each);
        }
        for (List<Integer> each : combine(n - 1, k)) {
            combineList.add(each);
        }
        return combineList;
    }
}
