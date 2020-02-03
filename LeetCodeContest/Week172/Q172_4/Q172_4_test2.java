import java.util.Arrays;
import java.util.Comparator;

public class Q172_4_test2 {
    public int minTaps(int n, int[] ranges) {
        int effectN = 0;
        for (int i = 0; i < n + 1; i++) {
            if (ranges[i] != 0) effectN++;
        }
        int[][] newRanges = new int[effectN][2];
        int effect = 0;
        for (int i = 0; i < n + 1; i++) {
            if (ranges[i] != 0) {
                newRanges[effect][0] = Math.max(0, i - ranges[i]);
                newRanges[effect][1] = Math.min(n, i + ranges[i]);
            }
        }

        Arrays.sort(newRanges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else if (o1[0] > o2[0]) return 1;
                else {
                    if (o1[1] > o2[1]) return -1;
                    else if (o1[1] < o2[1]) return 1;
                    else return 0;
                }
            }
        });
        int rightLimit = 0, num = 1;
        int i = 0;
        while (i < effectN && newRanges[i][0] <= rightLimit) {
            int curRightLimit = newRanges[i][1], maxP = i + 1;
            int j = i + 1;
            while (j < effectN && newRanges[j][0] <= rightLimit) {
                if (newRanges[j][1] > curRightLimit) {
                    curRightLimit = newRanges[j][1];
                    maxP = j;
                }
                j++;
            }
            if (curRightLimit <= rightLimit) break;
            rightLimit = curRightLimit;
            i = maxP;
            num++;
        }
        if (rightLimit < n) return -1;
        return num;
    }
}
