public class Q383_test1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dictionary = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        for (int i = 0; i < m; i++) {
            dictionary[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            dictionary[ransomNote.charAt(i) - 'a']--;
            if (dictionary[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
