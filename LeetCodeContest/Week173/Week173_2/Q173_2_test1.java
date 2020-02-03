import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q173_2_test1 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return -1;
                else if (o1[1] < o2[1]) return 1;
                else {
                    return o2[0] - o1[0];
                }
            }
        });
        List<Integer> list = new ArrayList<>();
        int n = restaurants.length;
        for (int i = 0; i < n; i++) {
            if (veganFriendly == 1 && restaurants[i][2] == 0) continue;
            if (restaurants[i][3] > maxPrice || restaurants[i][4] > maxDistance) continue;
            list.add(restaurants[i][0]);
        }
        return list;
    }
}
