import java.util.Comparator;
import java.util.PriorityQueue;

public class Q174_2_test2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length; if (m == 0) return new int[]{};
        int n = mat[0].length;
        if (k == 0) return new int[] {};
        int[] rowSum = new int[m];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (rowSum[o2] - rowSum[o1] > 0) return 1;
                else if (rowSum[o2] - rowSum[o1] < 0) return -1;
                else {
                    if (o2 - o1 > 0) return 1;
                    else return -1;
                }
            }
        });
        for (int i = 0; i < m; i++) {
            rowSum[i] = sum(mat, i);
            if (priorityQueue.size() < k) priorityQueue.add(i);
            else if (rowSum[i] < rowSum[priorityQueue.peek()]) {
                priorityQueue.remove(); priorityQueue.add(i);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i > -1; i--) res[i] = priorityQueue.remove();
        return res;
    }

    private int sum(int[][] matrix, int row) {
        int sum = 0, n = matrix[row].length;
        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == 0) break;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1,1,0,0,0},
 {1,1,1,1,0},
 {1,0,0,0,0},
 {1,1,0,0,0},
 {1,1,1,1,1}
        };
        new Q174_2_test2().kWeakestRows(a, 3);
    }
}
