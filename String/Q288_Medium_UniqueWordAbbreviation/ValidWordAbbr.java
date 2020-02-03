import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {

    HashMap<String, Integer> hashMap;
    HashSet<String> words;

    public ValidWordAbbr(String[] dictionary) {
        hashMap = new HashMap<>();
        words = new HashSet<>();
        for (String each : dictionary) {
            String s = convert(each);
            if (words.contains(each)) continue;
            if (!hashMap.containsKey(s)) hashMap.put(s, 0);
            hashMap.put(s, hashMap.get(s) + 1);
            words.add(each);
        }
    }

    public boolean isUnique(String word) {
        String s = convert(word);
        return !hashMap.containsKey(s) || (hashMap.get(s) == 1 && words.contains(word));
    }

    private String convert(String s) {
        int n = s.length();
        if (n <= 2) return s;
        StringBuilder sb = new StringBuilder();
        return sb.append(s.charAt(0)).append(n - 2).append(s.charAt(n - 1)).toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */