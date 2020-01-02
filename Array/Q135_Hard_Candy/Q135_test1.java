import java.util.ArrayList;
import java.util.List;

public class Q135_test1 {
    public int candy(int[] ratings) {
        List<Integer> minList = new ArrayList<>();
        int n = ratings.length;
        for (int i = 0; i < n; i++) {
            if ((i - 1 < 0 || ratings[i - 1] >= ratings[i]) && (i + 1 >= n || ratings[i + 1] >= ratings[i])) {
                minList.add(i);
            }
        }
        int[] candy = new int[n];
        for (Integer each : minList) {
            candy[each] = 1;
            int t = each;
            while (t > 0 && ratings[t] < ratings[t - 1]) {
                if (candy[t] + 1 > candy[t - 1]) candy[t - 1] = candy[t] + 1;
                t--;
            }
            t = each;
            while (t < n - 1 && ratings[t] < ratings[t + 1]) {
                if (candy[t] + 1 > candy[t + 1]) candy[t + 1] = candy[t] + 1;
                t++;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 2};
        new Q135_test1().candy(a);
    }
}
