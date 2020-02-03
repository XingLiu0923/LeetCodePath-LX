import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q267_test1 {
    public List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!hashMap.containsKey(c)) hashMap.put(c, 0);
            hashMap.put(s.charAt(i), hashMap.get(c) + 1);
        }
        int count = 0;
        char Center = '\0';
        for (char each : hashMap.keySet()) {
            int showT = hashMap.get(each);
            if (showT % 2 == 1) {
                Center = each;
                count++;
            }
            if (count > 1) return list;
            hashMap.put(each, showT / 2);
        }

        String halfS = "";
        if (Center != '\0') halfS += Center;
        dfs(halfS, list, hashMap, n / 2);
        List<String> wholeList = new ArrayList<>();
        if (n % 2 == 1) {
            for (String each : list) {
                each = each + new StringBuilder(each.substring(0, each.length() - 1)).reverse();
                wholeList.add(each);
            }
        } else {
            for (String each : list) {
                each = each + new StringBuilder(each).reverse();
                wholeList.add(each);
            }
        }
        return wholeList;
    }

    private void dfs(String halfS, List<String> list, HashMap<Character, Integer> hashMap, int leftNum) {
        if (leftNum == 0) {
            list.add(halfS); return;
        }
        for (char each : hashMap.keySet()) {
            int times = hashMap.get(each);
            if (times > 0) {
                hashMap.put(each, times - 1);
                dfs(each + halfS, list, hashMap, leftNum - 1);
                hashMap.put(each, times);
            }
        }
    }
}
