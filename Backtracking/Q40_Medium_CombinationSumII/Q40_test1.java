import java.util.ArrayList;
import java.util.List;

public class Q40_test1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        QuickSort(candidates, 0, n);
        return combinationSum2(candidates, n, target);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int hi, int target) {
        List<List<Integer>> combinationList = new ArrayList<>();
        if (target < 0 || hi < 0) return combinationList;
        if (target == 0) {
            List<Integer> combination = new ArrayList<>();
            combinationList.add(combination);
            return combinationList;
        }
        int i = 0, j = 0;
        while (j < hi) {
            while (j < hi - 1 && candidates[j] == candidates[j + 1]) j++;
            List<Integer> tmp = new ArrayList<>();
            for (int k = 0; k < j - i + 1; k++) {
                int lastTarget = target - candidates[j] * (k + 1);
                List<List<Integer>> lastList = combinationSum2(candidates, i, lastTarget);
                tmp.add(candidates[j]);
                for (List<Integer> each : lastList) {
                    List<Integer> newEach = new ArrayList<>(each);
                    newEach.addAll(tmp);
                    combinationList.add(newEach);
                }
            }
            j++; i = j;
        }
        return combinationList;
    }

    private void QuickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int partition = partition(a, lo, hi);
        QuickSort(a, lo, partition);
        QuickSort(a, partition + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        for (int j = lo + 1; j < hi; j++) {
            if (a[j] <= a[lo]) swap(a, ++i, j);
        }
        swap(a, i, lo);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    public static void main(String[] args) {
        int[] a = {10,1,2,7,6,1,5};
        new Q40_test1().combinationSum2(a, 8);
    }
}
