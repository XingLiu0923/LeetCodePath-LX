public class Q167_test2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0; int j = numbers.length - 1;      //i，j分别从头尾向后向前扫描；
        int sum = 0;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum < target) j++;
            else if (sum > target) i--;
            else break;
        }
        int[] ans = {i + 1, j + 1};
        return ans;
    }
}
