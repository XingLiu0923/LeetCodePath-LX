public class Q42_test3 {
    public int trap(int[] height) {
        int n = height.length;
        int max_left = 0, max_right = 0;
        int i = 1, j = n - 2;
        int rain = 0;
        while (j >= i){
            if (height[i - 1] < height[j + 1]) {
                max_left = Math.max(height[i - 1], max_left);
                if (max_left - height[i] > 0) rain += (max_left - height[i]);
                i++;
            } else {
                max_right = Math.max(height[j + 1], max_right);
                if (max_right - height[j] > 0) rain += (max_right - height[j]);
                j--;
            }
        }
        return rain;
    }
}
