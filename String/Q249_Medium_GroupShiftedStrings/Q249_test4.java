import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q249_test4 {
    public List<List<String>> groupStrings(String[] strings) {
        int n = strings.length;
        List<List<String>> groupList = new ArrayList<>();
        HashMap<String, Integer> groupMap = new HashMap<>();
        int groupTotal = 0;
        for (int i = 0; i < n; i++) {
            String s = moveToA(strings[i]);
            if (groupMap.containsKey(s)) groupList.get(groupMap.get(s)).add(strings[i]);
            else {
                groupMap.put(s, groupTotal++);
                List<String> group = new ArrayList<>();
                group.add(strings[i]);
                groupList.add(group);
            }
        }
        return groupList;
    }

    private String moveToA(String s) {
        char[] cs = s.toCharArray();
        int gap = cs[0] - 'a';
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            cs[i] = (char) ((cs[i] - gap));
            cs[i] = cs[i] < 'a' ? (char) (cs[i] + 26) : cs[i];
        }
        return String.valueOf(cs);
    }
}
