public class Q311_test1 {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowNum = A.length, colNum = B[0].length;
        int[][] res = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                res[i][j] = multiply(A, i, B, j);
            }
        }
        return res;
    }

    private int multiply(int[][] A, int rowA, int[][] B, int colB) {
        int sum = 0;
        int n = A[0].length;
        for (int i = 0; i < n; i++) {
            sum += A[rowA][i] * B[i][colB];
        }
        return sum;
    }
}
