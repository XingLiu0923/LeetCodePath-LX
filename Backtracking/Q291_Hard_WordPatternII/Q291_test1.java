import java.util.HashMap;
import java.util.HashSet;

public class Q291_test1 {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> hashMap = new HashMap<>();
        HashSet<String> revHashMap = new HashSet<>();
        return dfs(0, pattern, 0, str, hashMap, revHashMap);
    }

    private boolean dfs(int patternP, String pattern, int strP, String str, HashMap<Character, String> hashMap, HashSet<String> revHashMap) {
        if (patternP == pattern.length() && strP == str.length()) return true;
        if (patternP >= pattern.length() || strP >= str.length()) return false;
        char c = pattern.charAt(patternP);
        if (hashMap.containsKey(c)) {
            String matchS = hashMap.get(c);
            if (strP + matchS.length() > str.length() || !matchS.equals(str.substring(strP, strP + matchS.length()))) return false;
            return dfs(patternP + 1, pattern, strP + matchS.length(), str, hashMap, revHashMap);
        }
        for (int i = strP; i < str.length(); i++) {
            String matchS = str.substring(strP, i + 1);
            if (revHashMap.contains(matchS)) continue;
            hashMap.put(c, matchS);
            revHashMap.add(matchS);
            if (dfs(patternP + 1, pattern, i + 1, str, hashMap, revHashMap)) return true;
            hashMap.remove(c); revHashMap.remove(matchS);
        }
        return false;
    }

    public static void main(String[] args) {
        new Q291_test1().wordPatternMatch("abab", "redblueredblue");
    }
}
