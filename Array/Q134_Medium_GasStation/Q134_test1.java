public class Q134_test1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] gap = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            gap[i] = gas[i] - cost[i];
            sum = sum + gap[i];
        }
        if (sum < 0) return -1;     // 和小于0铁定不存在；
        int maxPos = 0; int count = 0; int begin = 0; int max = 0;
        for (int j = 0; j < n; j++) {
            if (gap[j] < 0) ;
            else {
                maxPos = getPositivePos(gap, j);
                if (maxPos == j) return j;
                else j = maxPos;
            }
        }
        return -1;
    }

    private static int getPositivePos(int[] a, int pos) {       // 从pos开始往后加，返回最后一个和为正的位置；
        int sum = 0; int n = a.length;
        for (int i = 0; i < n; i++, pos++) {
            sum = sum + a[(pos) % n];
            if (sum < 0) break;
        }
        return pos % n;
    }

    public static void main(String[] args) {
        int[] gas = { 5, 1, 2, 3, 4 };
        int[] cost = { 4, 4, 1, 5, 1};
        System.out.println(new Q134_test1().canCompleteCircuit(gas, cost));
    }
}
