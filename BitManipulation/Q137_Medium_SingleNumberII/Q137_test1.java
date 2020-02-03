public class Q137_test1 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int[] bin = nums[i] >= 0 ? posIntToBin(nums[i]) : negIntToBin(nums[i]);
            add(count, bin);
        }
        for (int i = 0; i < 32; i++) count[i] %= 3;
        if (count[31] == 1) return binToNegInt(count);
        return binToPosInt(count);
    }

    private void add(int[] nums1, int[] nums2) {
        for (int i = 0; i < 32; i++) {
            nums1[i] += nums2[i];
        }
    }

    private int[] posIntToBin(int n) {
        int[] bin = new int[32];
        int i = 0;
        while (n > 0) {
            bin[i++] = n % 2;
            n /= 2;
        }
        return bin;
    }

    private int[] negIntToBin(int n) {
        n = -(n + 1);
        int[] bin = posIntToBin(n);
        for (int i = 0; i < 32; i++) bin[i] = 1 - bin[i];
        return bin;
    }

    private int binToPosInt(int[] bin) {
        int sum = 0, base = 1;
        for (int i = 0; i < 32; i++) {
            if (bin[i] == 1) sum += base;
            base *= 2;
         }
        return sum;
    }

    private int binToNegInt(int[] bin) {
        for (int i = 0; i < 32; i++) bin[i] = 1 - bin[i];
        int n = binToPosInt(bin);
        return 0 - n - 1;
    }

    public static void main(String[] args) {
        int[] a = new Q137_test1().negIntToBin(-4);
        int b = new Q137_test1().binToNegInt(a);
        new Q137_test1().singleNumber(new int[] {0, 0, 0, 1, 1, 1, 99});
    }
}
