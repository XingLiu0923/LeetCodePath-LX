public class Q189_test2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length; k = k % n;
        for (int s = 0, count = 0; count < n; s++) {      // 从同余类s开始，下一次就是s+1；
            count = count + rotate(nums, k, s, n);
        }
    }

    private static int rotate(int[] nums, int k, int s, int n) {
        int tmp = nums[s]; int i = s; int j = (s - k + n) % n; int mov = 0;
        while (j != s) {
            nums[i] = nums[j]; i = j; j = (j - k + n) % n; mov++;
        }
        nums[(s + k) % n] = tmp;
        return mov + 1;
    }

    public static void main(String[] args) {
        Q189_test2 test = new Q189_test2();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        test.rotate(nums, 2);
        for (int each : nums) {
            System.out.println(each);
        }
    }
}
