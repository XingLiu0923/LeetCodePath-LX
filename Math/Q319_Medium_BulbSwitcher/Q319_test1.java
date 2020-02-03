public class Q319_test1 {
    public int bulbSwitch(int n) {
        boolean[] mark = new boolean[n + 1];
        for (int gap = 1; gap < n + 1; gap++) {
            for (int i = 0; i < n + 1; i = i + gap) {
                mark[i] = !mark[i];
            }
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (mark[i]) count++;
        }
        return count;
    }
}
