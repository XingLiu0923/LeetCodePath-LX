public class Q941_test1 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        if (A[0] >= A[1]) return false;     //确定边界；
        if (A[A.length - 1] >= A[A.length - 2]) return false;
        int topTimes = 0;
        for (int i = 0; i < A.length; i++) {
            if (topTimes > 1) return false;     //峰值个数大于1，返回错误；
            if (i > 0 && i < A.length - 1) {
                if (A[i] == A[i - 1]) return false;     //保证相邻的数不相等；
                if (A[i] < A[i - 1] && A[i] < A[i + 1]) return false;       //保证不出现类似低谷的点；
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) topTimes++;        //峰值点的定义，满足峰值个数+1；
            }
        }
        if (topTimes == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0,3,2,1};
        Q941_test1 test = new Q941_test1();
        System.out.println(test.validMountainArray(a));
    }
}
