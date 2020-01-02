public class Q151_test2 {
    public String reverseWords(String s) {
        String[] words = reverse(s).split("\\s+");
        int n = words.length;
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(reverse(words[i]) + " ");
        }
        String newS = sb.toString().trim();
        return newS;
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char t = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = t;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        new Q151_test2().reverseWords("the sky is blue");
    }
}
