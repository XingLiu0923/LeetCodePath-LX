public class Q135_test2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        candy[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candy[i] = candy[i - 1] + 1;
            else candy[i] = 1;
        }
        int sum = candy[n - 1];
        for (int i = n - 2; i > -1; i--) {
            if (ratings[i + 1] < ratings[i]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
            sum = sum + candy[i];
        }
        return sum;
    }
}
