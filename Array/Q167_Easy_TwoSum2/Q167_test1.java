public class Q167_test1 {
    //binSearch返回不大于目标数的最后一个值，注意序列已经按照严格升序排列好；
    public static int binSearch(int[] A, int k) {
        int lo = -1; int hi = A.length - 1; int mid = 0;
        while (lo < hi) {
            mid = hi - (hi - lo)/2;     //要找寻的是(]这样的区间形式，因此hi向lo逼近；
            if (A[mid] > k) hi = mid - 1;       //右闭，从闭区间逼近；
            else lo = mid;      //左开；
        }
        return hi;
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = binSearch(numbers, target > 0 ? target/2 : (target - 1)/2);       //i指向较小值，i必须在target的一半以下；
        int j = i + 1;      //j指向较大值，初始为i右边一个；
        if (i > 0 && numbers[i] == numbers[i - 1]) {        //有两个相等的值时，则往前移一位；
            i--; j--;
        }
        while (i >= 0 && j < numbers.length) {
            if (numbers[i] + numbers[j] == target) break;
            while (i >= 0 && numbers[i] + numbers[j] > target) i--;
            while (j < numbers.length && numbers[i] + numbers[j] < target) j++;
        }
        int[] ans = {i + 1, j + 1};
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 3, 4};
        System.out.println(binSearch(a, 0));
        int k = -1 / 2;
        System.out.println(-1 / 2);
    }
}
