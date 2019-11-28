public class Q387_test1 {
    public int firstUniqChar(String s) {
        int[] appearTimes = new int[26];
        for (int i = 0; i < 26; i++) {
            appearTimes[i] = -1;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int position = s.charAt(i) - 'a';
            if (appearTimes[position] == -1) appearTimes[position] = i;
            else appearTimes[position] = n;
        }
        int minPosition = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (appearTimes[i] > -1 && appearTimes[i] < minPosition) minPosition = appearTimes[i];
        }
        if (minPosition >= n) return -1;
        return minPosition;
    }

    public static void main(String[] args) {
        new Q387_test1().firstUniqChar("leetcode");
    }
}
