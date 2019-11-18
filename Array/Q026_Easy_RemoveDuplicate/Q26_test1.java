public class Q26_test1 {
    public int removeDuplicates(int[] nums) {
        int i = 0; int j = 1;       //i, j分别指向非重复数组的末尾和原数组的末尾；
        int numsLength = nums.length;
        while (j < numsLength) {
            if (nums[j] == nums[i]) j++;        //i与j相等，则j向后移动一位；
            else {
                nums[++i] = nums[j++];      //不想等，则给i赋值为j，同时向后移；
            }
        }
        return i + 1;
    }
}
