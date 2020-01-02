import java.util.Vector;

public class Q164_test2 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] minAndmax = getMinAndMax(nums);
        int interval = (minAndmax[1] - minAndmax[0] + 1) / (n + 1) + 1;     // 每个桶里面装的数量；
        Vector<Integer>[] boxes = new Vector[n + 1];
        for (int i = 0; i < n + 1; i++) {
            boxes[i] = new Vector<>();
        }
        for (int i = 0; i < n; i++) {
            boxes[(nums[i] - minAndmax[0])/interval].add(nums[i]);
        }
        int i = 0, j = 1;
        int maxGap = 0;
        while (j < n + 1) {
            if (boxes[j].size() != 0) { i++; j++; }
            else {
                while (j < n + 1 && boxes[j].size() == 0) j++;
                if (j >= n + 1) j = i;
                int min = getMin(boxes[j]);
                int max = getMax(boxes[i]);
                if (min - max > maxGap) maxGap = min - max;
                if (j == i) break;
                i = j - 1;
            }
        }
        return maxGap;
    }

    private int[] getMinAndMax(int[] nums) {
        int min = Integer.MAX_VALUE, max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        int[] minAndmax = {min, max};
        return minAndmax;
    }

    private int getMin(Vector<Integer> a) {
        int min = Integer.MAX_VALUE;
        for (Integer each : a) {
            if (each < min) min = each;
        }
        return min;
    }

    private int getMax(Vector<Integer> a ) {
        int max = 0;
        for (Integer each : a) {
            if (each > max) max = each;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1};
        new Q164_test2().maximumGap(a);
    }
}
