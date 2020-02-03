public class Q6_test1 {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int gap = 2 * (numRows - 1);
        if (gap == 0) return s;
        for (int i = 0; i < numRows; i++) {
            int point = i;
            int gap1 = gap - 2 * i, gap2 = gap - gap1;
            int j = 0;
            while (point < n) {
                sb.append(s.charAt(point));
                if (gap1 == 0) point += gap2;
                else if (gap2 == 0) point += gap1;
                else if (j % 2 == 0) { point += gap1; j++; }
                else { point += gap2; j++; }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Q6_test1().convert("A", 1);
    }
}
