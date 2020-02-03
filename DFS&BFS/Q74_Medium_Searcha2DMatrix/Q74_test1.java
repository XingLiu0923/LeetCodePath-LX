public class Q74_test1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; if (m == 0) return false;
        int n = matrix[0].length; if (n == 0) return false;
        int row = findRow(matrix, target);
        if (row < 0) return false;
        int col = findCol(matrix, row, target);
        if (col > n - 1) return false;
        return matrix[row][col] == target;
    }

    private int findRow(int[][] matrix, int target) {
        int lo = -1, hi = matrix.length - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo)/2;
            if (matrix[mid][0] > target) hi = mid - 1;
            else lo = mid;
        }
        return hi;
    }

    private int findCol(int[][] matrix, int row, int target) {
        int lo = 0, hi = matrix[0].length;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (matrix[row][mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
