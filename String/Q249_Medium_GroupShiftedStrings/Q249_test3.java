import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q249_test3 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groupList = new ArrayList<>();
        int n = strings.length;
        HashMap<String, Integer> groupMap = new HashMap<>();
        int listTotal = 0;
        for (int i = 0; i < n; i++) {
            if (groupMap.containsKey(strings[i])) groupList.get(groupMap.get(strings[i])).add(strings[i]);
            else {
                for (int j = 0; j < 26; j++) {
                    String x = nextString(strings[i], j);
                    groupMap.put(x, listTotal);
                }
                listTotal++;
                List<String> group = new ArrayList<>();
                group.add(strings[i]);
                groupList.add(group);
            }
        }
        return groupList;
    }

    private String nextString(String s, int i) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int j = 0; j < n; j++) {
            cs[j] = (char) (cs[j] + i > 'z' ? cs[j] + i - 26 : cs[j] + i);
        }
        return String.valueOf(cs);
    }
}
