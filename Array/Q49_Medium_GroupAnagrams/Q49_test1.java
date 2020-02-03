import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q49_test1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        int n = strs.length;
        HashMap<String, List<String>> listHashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String orderS = orderString(strs[i]);
            if (!listHashMap.containsKey(orderS)) listHashMap.put(orderS, new ArrayList<>());
            List<String> curList = listHashMap.get(orderS);
            curList.add(strs[i]);
        }
        for (String each : listHashMap.keySet()) {
            lists.add(listHashMap.get(each));
        }
        return lists;
    }

    private String orderString (String s) {
        int[] dic = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            dic[s.charAt(i) - 'a']++;
        }
        String result = "";
        for (int i = 0; i < 26; i++) {
            result += dic[i];
        }
        return result;
    }
}
