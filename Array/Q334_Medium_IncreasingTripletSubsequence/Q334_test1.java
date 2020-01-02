import java.util.List;
import java.util.Vector;

public class Q334_test1 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] triplet = new int[3];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int insertPos = insertLocation(triplet, size, nums[i]);
            triplet[insertPos] = nums[i];
            if (insertPos >= size) size++;
            if (size == 3) return true;
        }
        return false;
    }

    private int insertLocation(int[] triplet, int size, int target) {
        int i = 0;
        while (i < size && triplet[i] < target) i++;
        return i;
    }
}
