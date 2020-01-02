public class Q345_test1 {
    public String reverseVowels(String s) {
        int n = s.length();
        if (n == 0) return s;
        char[] chars = s.toCharArray();
        int i = 0, j = n - 1;
        int count = n;
        while (--count > 0) {
            if (!isVowels(chars[i])) i++;
            else if (!isVowels(chars[j])) j--;
            else {
                swap(chars, i++, j--);
                count--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
