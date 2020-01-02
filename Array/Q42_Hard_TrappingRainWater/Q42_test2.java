public class Q42_test2 {
    public int trap(int[] height) {
        int n = height.length;
        int[] max_left = new int[n], max_right = new int[n];
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i > -1; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        int rain_sum = 0;
        for (int i = 0; i < n; i++) {
            int min_max = Math.min(max_left[i], max_right[i]);
            if (height[i] < min_max) rain_sum += (min_max - height[i]);
        }
        return rain_sum;
    }
}
