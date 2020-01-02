public class Q11_test1 {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxA = 0;
        while (j > i) {
            int area = Math.abs(j - i) * Math.min(height[i], height[j]);
            maxA = area > maxA ? area : maxA;
            if (height[i] < height[j]) i++;
            if (height[j] < height[i]) j--;
            else {
                i++; j--;
            }
        }
        return maxA;
    }
}
