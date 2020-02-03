import java.util.ArrayList;
import java.util.List;

public class Q60_test1 {
    public String getPermutation(int n, int k) {
        List<String> numList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            count = count * (i + 1);
            numList.add(Integer.toString(i + 1));
        }
        StringBuilder sb = new StringBuilder();
        k--;
        while (k > 0) {
            count = count / n;
            int index = k / count;
            sb.append(numList.remove(index));
            k = k % count;
            n--;
        }
        for (String each : numList) {
            sb.append(each);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Q60_test1().getPermutation(4, 9);
    }
}
