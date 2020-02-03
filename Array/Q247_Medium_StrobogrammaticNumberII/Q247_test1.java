import java.util.ArrayList;
import java.util.List;

public class Q247_test1 {
    public List<String> findStrobogrammatic(int n) {
        List<String> stringList = new ArrayList<>();
        if (n == 0) {
            stringList.add("");
            return stringList;
        }
        if (n == 1) {
            stringList.add("1");
            stringList.add("0");
            stringList.add("8");
            return stringList;
        }
        List<String> lastList = findStrobogrammatic(n - 2);
        for (String each : lastList) {
            String firstHalf = n - 2 <= 1 ? "" : each.substring(0, (n - 2)/2),
                    lastHalf = n - 2 <= 1 ? "" : each.substring(n - 2 - (n - 2)/2, n - 2);
            String c = ((n - 2) % 2 == 0) ? "" : String.valueOf(each.charAt((n - 2) / 2));
            stringList.add(firstHalf + "1" + c + "1" + lastHalf);
            stringList.add(firstHalf + "8" + c + "8" + lastHalf);
            stringList.add(firstHalf + "6" + c + "9" + lastHalf);
            stringList.add(firstHalf + "9" + c + "6" + lastHalf);
            if (firstHalf.length() != 0) stringList.add(firstHalf + "0" + c + "0" + lastHalf);
        }
        return stringList;
    }

    public static void main(String[] args) {
        new Q247_test1().findStrobogrammatic(2);
    }
}
