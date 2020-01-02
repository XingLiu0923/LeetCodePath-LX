public class Q164_test1 {
    public int maximumGap(int[] nums) {
        int max = 0;
        int n = nums.length;
        if (n == 1) return 0;
        for (int i = 0; i < n; i++) {
            if (max < nums[i]) max = nums[i];
        }
        int d = 1;
        while (max / (int)(Math.pow(10, d++)) > 0);
        radixSort(nums, d - 1);
        int maxGap = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxGap) maxGap = nums[i] - nums[i - 1];
        }
        return maxGap;
    }

    private void radixSort(int[] nums, int d) {
        int n = nums.length;
        int[][] box = new int[10][n];
        int[] boxSize = new int[10];
        for (int i = 0; i < d; i++) {
            int devidor = (int)Math.pow(10, i);
            for (int j = 0; j < n; j++) {
                int boxNum = (nums[j] / devidor) % 10;
                box[boxNum][boxSize[boxNum]++] = nums[j];
            }
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < boxSize[j]; l++) {
                    nums[k++] = box[j][l];
                }
                boxSize[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {15252,16764,27963,7817};
        new Q164_test1().maximumGap(a);
    }
}
