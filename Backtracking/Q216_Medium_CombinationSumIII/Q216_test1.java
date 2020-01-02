import java.util.ArrayList;
import java.util.List;

public class Q216_test1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 10);
    }

    private List<List<Integer>> combinationSum3(int k, int n, int upLimit) {
        List<List<Integer>> combinationList = new ArrayList<>();
        if (k < 0 || n < 0 || upLimit <= k) return combinationList;
        if (n == 0 && k == 0) {
            List<Integer> combination = new ArrayList<>();
            combinationList.add(combination);
            return combinationList;
        }
        for (int i = k; i < upLimit; i++) {
            List<List<Integer>> lastCombinationList = combinationSum3(k - 1, n - i, i);
            for (List<Integer> each : lastCombinationList) {
                each.add(i);
                combinationList.add(each);
            }
        }
        return combinationList;
    }
}
