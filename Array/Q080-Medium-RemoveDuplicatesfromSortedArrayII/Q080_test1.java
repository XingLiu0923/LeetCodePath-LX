public class Q080_test1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0; int j = 0;
        while (j < nums.length - 1){
            if (i == 0 || (nums[i - 1] != nums[i]) || (nums[j] != nums[j + 1])) {
                i++; j++;
                nums[i] = nums[j];
            } else {
                j++;
            }
        }
        return i + 1;
    }
}
