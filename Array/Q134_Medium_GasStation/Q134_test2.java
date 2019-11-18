public class Q134_test2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int currentSum = 0;
        int n = gas.length; int pos = 0;
        for (int i = 0; i < n; i++) {
            totalSum += gas[i] - cost[i];
            currentSum += gas[i] - cost[i];
            if (currentSum < 0) {
                currentSum = 0;
                pos = i + 1;
            }
        }
        return totalSum < 0 ? -1 : pos;
    }
}
