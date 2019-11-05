public class Q167_review_191104 {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int sum = 0;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) break;
            else if (sum < target) i++;
            else j--;
        }
        int[] result = new int[] {i + 1, j + 1};
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] resuls = twoSum(numbers, target);
        for (int result : resuls) {
            System.out.println(result);
        }
    }
}
