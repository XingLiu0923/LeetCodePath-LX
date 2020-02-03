import java.util.Arrays;
import java.util.Comparator;

public class Q172_4_test3 {
    public int minTaps(int n, int[] ranges) {
        int[] land = new int[n];
        for (int i = 0; i < n + 1; i++) {
            int leftLimit = Math.max(0, i - ranges[i]);
            int rightLimit = Math.min(n, i + ranges[i]);
            while (leftLimit < rightLimit) land[leftLimit] = Math.max(rightLimit, land[leftLimit++]);
        }
        int num = 0, i = 0;
        while (i < n && land[i] > i) {
            num++;
            i = land[i];
        }
        if (i < n) return -1;
        return num;
    }
}
