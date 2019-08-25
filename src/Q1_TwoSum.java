public class Q1_TwoSum {
    public int[] towSum(int[] nums, int target) {
        int[] results = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    results[0] = nums[i];
                    results[1] = nums[j];
                }
            }
        }

        return results;
    }
}
