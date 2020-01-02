import java.util.ArrayList;
import java.util.List;

public class Q166_2_test2 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        int n = groupSizes.length;
        if (n == 0) return list;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(groupSizes, index, 0, n);
        for (int i = 0; i < n; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < groupSizes[index[i]]; j++) {
                tmpList.add(index[i + j]);
            }
            list.add(tmpList);
            i = i + groupSizes[index[i]] - 1;
        }

        return list;
    }

    private void mergeSort(int[] num, int[] index, int lo, int hi) {
        if (lo >= hi - 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(num, index, lo, mid);
        mergeSort(num, index, mid, hi);
        merge(num, index, lo, mid, hi);
    }

    private void merge(int[] num, int[] index, int lo, int mid, int hi) {
        int[] tmpIndex = new int[hi - lo];
        int i = lo, j = mid;
        for (int count = 0; count < hi - lo; count++) {
            if (i >= mid) { tmpIndex[count] = index[j++]; }
            else if (j >= hi) { tmpIndex[count] = index[i++]; }
            else if (num[index[j]] < num[index[i]]) { tmpIndex[count] = index[j++]; }
            else tmpIndex[count] = index[i++];
        }
        for (int count = 0; count < hi - lo; count++) {
            index[lo + count] = tmpIndex[count];
        }
    }
}
