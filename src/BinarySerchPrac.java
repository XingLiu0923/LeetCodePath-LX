public class BinarySerchPrac {
    public static int Binary_nomorethan(int[] a, int k) {
        int lo = -1; int hi = a.length - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo)/2;
            if (a[mid] > k) hi = mid - 1;
            else lo = mid;
        }
        return hi;
    }

    public static int Binary_nolessthan(int[] a, int k) {
        int lo = 0; int hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (a[mid] < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 0, 3, 3, 3, 7, 8, 9};
        int result1 = Binary_nolessthan(a, 10);
        int result2 = Binary_nomorethan(a, 10);
        System.out.println(result1);
        System.out.println(result2);
    }
}
