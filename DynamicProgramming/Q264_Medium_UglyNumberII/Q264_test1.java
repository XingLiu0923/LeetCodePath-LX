public class Q264_test1 {
    public int nthUglyNumber(int n) {
        int[] uglyNum = new int[n];
        int dp2 = 0, dp3 = 0, dp5 = 0;
        uglyNum[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNum[i] = Math.min(uglyNum[dp2] * 2, Math.min(uglyNum[dp3] * 3, uglyNum[dp5] * 5));
            if (uglyNum[dp2] * 2 <= uglyNum[i]) dp2++;
            if (uglyNum[dp3] * 3 <= uglyNum[i]) dp3++;
            if (uglyNum[dp5] * 5 <= uglyNum[i]) dp5++;
        }
        return uglyNum[n - 1];
    }
}
