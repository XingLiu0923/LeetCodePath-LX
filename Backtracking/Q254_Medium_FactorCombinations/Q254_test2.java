import java.util.ArrayList;
import java.util.List;

public class Q254_test2 {
    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }

    private List<List<Integer>> getFactors(int n, int min_factor) {
        List<List<Integer>> factorList = new ArrayList<>();
        for (int i = min_factor; i * i <= n; i++) {
            if (n % i == 0) {
                List<Integer> factor = new ArrayList<>();
                factor.add(n / i);
                factor.add(i);
                factorList.add(factor);
                for (List<Integer> each : getFactors(n / i, i)) {
                    each.add(i);
                    factorList.add(each);
                }
            }
        }
        return factorList;
    }
}
