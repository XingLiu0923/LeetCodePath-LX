public class Q273_test3 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] temp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) temp[n]++;
            else temp[citations[i]]++;
        }
        int sum = 0;
        int k = 0;
        for (k = n; k > -1 && sum <= k; k--) {
            sum = sum + temp[k];
        }
        return k + 1;
    }
}
