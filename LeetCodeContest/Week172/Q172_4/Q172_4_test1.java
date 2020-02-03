import java.util.Arrays;
import java.util.Comparator;

public class Q172_4_test1 {
    public int minTaps(int n, int[] ranges) {
        int effectN = 0;
        for (int i = 0; i < n + 1; i++) {
            if (ranges[i] > 0) effectN++;
        }
        if (effectN == 0) return -1;
        int[][] range = new int[effectN][2];
        int effect = 0;
        for (int i = 0; i < n + 1; i++) {
            if (ranges[i] != 0) {
                range[effect][0] = Math.max(i - ranges[i], 0);
                range[effect][1] = Math.min(i + ranges[i] - 1, n - 1);
                effect++;
            }
        }
        Arrays.sort(range, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] < 0) return -1;
                else if (o1[0] - o2[0] > 0) return 1;
                else {
                    if (o1[1] - o2[1] > 0) return -1;
                    else if (o1[1] - o2[1] < 0) return 1;
                    else return 0;
                }
            }
        });
        if (range[0][0] > 0) return -1;
        int max = range[0][0] + range[0][1], num = 1;
        int i = 0;
        while (i < effectN) {
            if (range[i][0] > max + 1) return -1;
            int curMax = max, curNext = i;
            int j = i + 1;
            while (j < effectN && range[j][0] <= max + 1) {
                if (range[j][1] > curMax) {
                    curMax = range[j][1];
                    curNext = j;
                }
                j++;
            }
            if (curMax <= max) break;
            i = curNext; max = curMax;
            num++;
        }
        if (max < n - 1) return -1;
        return num;
    }

    public static void main(String[] args) {
        new Q172_4_test1().minTaps(7, new int[] {1,2,1,0,2,1,0,1});
    }
}
