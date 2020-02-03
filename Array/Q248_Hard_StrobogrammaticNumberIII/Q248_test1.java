import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Q248_test1 {

    public int strobogrammaticInRange(String low, String high) {
        int lowL = low.length(), highL = high.length();
        int count = 0;
        if (lowL == highL) {
            List<String> list = strobogrammaticInRange(lowL);
            for (String each : list) {
                if (each.compareTo(low) >= 0 && each.compareTo(high) <= 0) count++;
            }
        } else if (lowL < highL) {
            List<String> lowList = strobogrammaticInRange(lowL);
            for (String each : lowList) {
                if (each.compareTo(low) >= 0) count++;
            }
            List<String> highList = strobogrammaticInRange(highL);
            for (String each : highList) {
                if (each.compareTo(high) <= 0) count++;
            }
            for (int i = lowL + 1; i < highL; i++) {
                count += numOfS(i);
            }
        }
        return count;
    }

    private List<String> strobogrammaticInRange(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) { list.add(""); return list; }
        List<String> tmpList = halfStr(n / 2);
        List<String> halfList = new ArrayList<>();
        if (n % 2 == 1) {
            for (String each : tmpList) {
                halfList.add(each + "0"); halfList.add(each + "1"); halfList.add(each + "8");
            }
        } else {
            halfList.addAll(tmpList);
        }
        for (String halfS : halfList) {
            for (int j = n / 2 - 1; j > -1; j--) {
                char c = halfS.charAt(j);
                if (c == '0') halfS += '0';
                else if (c == '1') halfS += '1';
                else if (c == '6') halfS += '9';
                else if (c == '8') halfS += '8';
                else halfS += '6';
            }
            list.add(halfS);
        }
        return list;
    }

    private List<String> halfStr(int halfN) {
        List<String> halfList = new ArrayList<>();
        if (halfN == 0) { halfList.add(""); return halfList; }
        dfs(halfList, "1", halfN - 1);
        dfs(halfList, "6", halfN - 1);
        dfs(halfList, "8", halfN - 1);
        dfs(halfList, "9", halfN - 1);
        return halfList;
    }

    private void dfs(List<String> halfList, String s, int leftN) {
        if (leftN == 0) { halfList.add(s); return; }
        dfs(halfList, s + "0", leftN - 1);
        dfs(halfList, s + "1", leftN - 1);
        dfs(halfList, s + "6", leftN - 1);
        dfs(halfList, s + "8", leftN - 1);
        dfs(halfList, s + "9", leftN - 1);
    }

    private int numOfS(int n) {
        if (n == 0) return 0;
        int count = 1;
        count = 4 * (int) Math.pow(5, n / 2 - 1);
        if (n % 2 == 1) count = count * 3;
        return count;
    }

    public static void main(String[] args) {
        List list = new Q248_test1().strobogrammaticInRange(3);
        System.out.print(new Q248_test1().strobogrammaticInRange("0", "100000000000000"));
    }
}
