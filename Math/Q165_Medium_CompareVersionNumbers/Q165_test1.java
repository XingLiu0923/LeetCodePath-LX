public class Q165_test1 {
    public int compareVersion(String version1, String version2) {
        String[] v1= version1.split("\\."), v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        int n1 = v1.length, n2 = v2.length;
        int[] nums1 = new int[n], nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < n1) nums1[i] = Integer.valueOf(v1[i]);
            if (i < n2) nums2[i] = Integer.valueOf(v2[i]);
        }
        for (int i = 0; i < n; i++) {
            if (nums1[i] < nums2[i]) return -1;
            if (nums2[i] < nums1[i]) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        new Q165_test1().compareVersion("0.1", "1.0");
    }
}
