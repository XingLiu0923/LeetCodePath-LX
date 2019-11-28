import java.util.List;

public class Q120_test1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minSum = new int[n];
        int[] lastMinSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                lastMinSum[k] = minSum[k];
            }
            for (int j = 0; j < i + 1; j++) {
               minSum[j] =  (j == 0 ? lastMinSum[j] : j == i ? lastMinSum[j - 1] : Math.min(lastMinSum[j], lastMinSum[j - 1])) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (minSum[i] < min) min = minSum[i];
        }
        return min;
    }
}
