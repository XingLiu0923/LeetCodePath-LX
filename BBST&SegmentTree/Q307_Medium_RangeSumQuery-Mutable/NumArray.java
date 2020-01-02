class NumArray {

    private int[] C;
    private int[] nums;
    private int size;

    public NumArray(int[] nums) {
        int n = nums.length;
        size = n;
        C = new int[n + 1];
        this.nums = nums;
        int[] prev = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prev[i] = prev[i - 1] + nums[i - 1];
            C[i] = prev[i] - prev[i - lowbit(i)];
        }
    }

    public void update(int i, int val) {
        int gap = val - nums[i];
        nums[i] = val;
        int p = i + 1;
        while (p <= size) {
            C[p] += gap;
            p += lowbit(p);
        }
    }

    public int sumRange(int i, int j) {
        return sumBefore(j) - sumBefore(i - 1);
    }

    private int sumBefore(int i) {
        int p = i + 1, r = 0;
        while (p > 0) {
            r += C[p];
            p -= lowbit(p);
        }
        return r;
    }

    private int lowbit(int x) {
        return x & (-x);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */