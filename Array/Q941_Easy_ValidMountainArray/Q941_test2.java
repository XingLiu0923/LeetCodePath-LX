public class Q941_test2 {
    public boolean validMountainArray(int[] A) {
        int i = 0; int j = A.length - 1;
        if (j - i < 2) return false;
        while (i < j && A[i] < A[i + 1]) i++;       //递增时，i往右走；
        while (j > i && A[j] < A[j - 1]) j--;       //递减时，j往左走；
        if(i > 0 && j < A.length - 1 && i == j) return true;        //要满足的条件是i，j不能在两端且必须相等；
        else return false;
    }

    public static void main(String[] args) {
        int[] a = {0, 3, 2, 1};
        Q941_test2 test = new Q941_test2();
        System.out.println(test.validMountainArray(a));
    }
}
