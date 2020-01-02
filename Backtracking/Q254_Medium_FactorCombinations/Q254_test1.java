import java.util.ArrayList;
import java.util.List;

public class Q254_test1 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> factorsList = new ArrayList<>();
        if (n == 1) return factorsList;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i != 0) continue;
            for (List<Integer> each : getFactors(n/i, i)) {
                each.add(i);
                factorsList.add(each);
            }
        }
        return factorsList;
    }

    private List<List<Integer>> getFactors(int num, int min_fac) {
        List<List<Integer>> factorList = new ArrayList<>();
        List<Integer> factor = new ArrayList<>();
        factor.add(num);
        factorList.add(factor);
        for (int i = min_fac; i <= Math.sqrt(num); i++) {
            if (num % i != 0) continue;
            for (List<Integer> each : getFactors(num / i, i)) {
                each.add(i);
                factorList.add(each);
            }
        }
        return factorList;
    }

    public static void main(String[] args) {
        new Q254_test1().getFactors(12);
    }
}
