import java.util.ArrayList;
import java.util.List;

public class Q315_test2 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> countList = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return countList;
        Pairs[] pairs = new Pairs[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pairs(nums[i], i);
        }
        int[] count = new int[n];
        mergeCount(pairs, count, 0, n);
        for (int i = 0; i < n; i++) {
            countList.add(i, count[i]);
        }
        return countList;
    }

    class Pairs {
        int number;
        int numberIndex;

        Pairs(int n, int index) {
            number = n;
            numberIndex = index;
        }
    }

    private void mergeCount(Pairs[] pairs, int[] count, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeCount(pairs, count, lo, mid);
        mergeCount(pairs, count, mid, hi);
        merge(pairs, count, lo, mid, hi);
    }

    private void merge(Pairs[] pairs, int[] count, int lo, int mid, int hi) {
        Pairs[] tmpPairs = new Pairs[hi - lo];
        int i = lo, j = mid;
        for (int mark = 0; mark < hi - lo; mark++) {
            if (i >= mid) { tmpPairs[mark] = pairs[j++]; }
            else if (j >= hi) { count[pairs[i].numberIndex] += (mark + lo - i); tmpPairs[mark] = pairs[i++]; }
            else if (pairs[j].number < pairs[i].number) { tmpPairs[mark] = pairs[j++]; }
            else { count[pairs[i].numberIndex] += (mark + lo - i); tmpPairs[mark] = pairs[i++]; }
        }
        for (int mark = 0; mark < hi - lo; mark++) {
            pairs[mark + lo] = tmpPairs[mark];
        }
    }
}
