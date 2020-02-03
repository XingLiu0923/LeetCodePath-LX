public class Q137_test2 {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int sum = 0, base = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += ((nums[j] >>> i) & 1);
            }
            if (count % 3 != 0) {
                sum |= (1 << (i));
            }
        }
        return sum;
    }
}
