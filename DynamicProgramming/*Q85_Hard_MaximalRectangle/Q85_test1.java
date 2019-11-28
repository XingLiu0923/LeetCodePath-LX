import com.sun.tools.corba.se.idl.constExpr.And;

public class Q85_test1 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int MaxArea = 0;
        for (int i = 0; i < m; i++) {
            char[] AndResult = matrix[i].clone();
            for (int j = i; j > -1; j--) {
                int ones = countMaxOnes(AndResult);
                if (ones == 0) break;
                int area = ones * (i - j + 1);
                if (area > MaxArea) MaxArea = area;
                if (j > 0) AndResult = AndLine(AndResult, matrix[j - 1]);
            }
        }
        return MaxArea;
    }

    private char[] AndLine(char[] line1, char[] line2) {
        char[] AndResult = new char[line1.length];
        for (int i = 0; i < line1.length; i++) {
            AndResult[i] = (line1[i] == '1' && line2[i] == '1') ? '1' : '0';
        }
        return AndResult;
    }

    private int countMaxOnes(char[] AndResult) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < AndResult.length; i++) {
            if (AndResult[i] == '0') {
                if (sum > max) max = sum;
                sum = 0;
            } else {
                sum++;
            }
        }
        if (sum > max) max = sum;
        return max;
    }
}
