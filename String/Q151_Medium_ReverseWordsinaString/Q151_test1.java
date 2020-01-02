public class Q151_test1 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) return s;
        reverseChar(chars, 0, n);
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (chars[j] != ' ') { chars[i++] = chars[j];}
            else { if (i > 0 && chars[i - 1] != ' ') chars[i++] = chars[j]; }
        }
        if (i == 0) return "";
        if (chars[i - 1] == ' ') i--;
        char[] newChar = new char[i];
        for (int k = 0; k < i; k++) {
            newChar[k] = chars[k];
        }
        i = 0; int j = 0; n = newChar.length;
        while (i < n) {
            for (j = i; j < n && newChar[j] != ' '; j++);
            reverseChar(newChar, i, j);
            i = j + 1;
        }
        return String.valueOf(newChar);
    }

    private void reverseChar(char[] chars, int lo, int hi) {
        for (int i = lo; i < lo + (hi - lo)/2; i++) {
            char t = chars[i];
            chars[i] = chars[hi + lo - 1 - i];
            chars[hi + lo - 1 - i] = t;
        }
    }

    public static void main(String[] args) {
        String s = "  ";
        String[] string = s.split("\\s+");
    }
}
