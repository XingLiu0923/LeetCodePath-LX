public class Q168_1_test1 {
    public int findNumbers(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isEven(nums[i])) sum++;
        }
        return sum;
    }

    private boolean isEven(int num) {
        boolean mark = true;
        while (num > 0) {
            num = num / 10;
            mark = !mark;
        }
        return mark;
    }
}
