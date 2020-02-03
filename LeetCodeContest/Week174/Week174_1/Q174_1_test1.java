import java.util.Arrays;
import java.util.HashMap;

public class Q174_1_test1 {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(arr[i])) hashMap.put(arr[i], 0);
            int c = hashMap.get(arr[i]);
            hashMap.put(arr[i], c + 1);
        }
        int[] res = new int[hashMap.size()];
        int count  = 0;
        for (int key : hashMap.keySet()) {
            res[count++] = hashMap.get(key);
        }
        count = 0;
        int resCount = 0;
        Arrays.sort(res);
        for (int i = res.length - 1; i > -1; i--) {
            count += res[i];
            resCount++;
            if (count >= arr.length / 2) break;
        }
        return resCount;
    }

    public static void main(String[] args) {
        new Q174_1_test1().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});
    }
}