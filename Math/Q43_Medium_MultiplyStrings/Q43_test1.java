public class Q43_test1 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if (n1 == 0 || n2 == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        String num1Reverse = new StringBuilder(num1).reverse().toString();
        String num2Reverse = new StringBuilder(num2).reverse().toString();
        String s = "";
        for (int i = n2 - 1; i > -1; i--) {
            String timesResult = multip(num1Reverse, num2Reverse.charAt(i));
            s = add("0" + s, timesResult);
        }
        return new StringBuilder(s).reverse().toString();
    }

    private String add(String num1, String num2) {  // reverse;
        int n1 = num1.length(), n2 = num2.length();
        int n = Math.max(n1, n2);
        int next = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num1digit = i < n1 ? (num1.charAt(i) - '0') : 0;
            int num2digit = i < n2 ? (num2.charAt(i) - '0') : 0;
            int newDigit = num1digit + num2digit + next;
            if (newDigit >= 10) { newDigit = newDigit - 10; next = 1; }
            else next = 0;
            sb.append(newDigit);
        }
        if (next == 1) sb.append(1);
        return sb.toString();
    }

    private String multip(String num1, char c) {
        int n = num1.length();
        int next = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int digit1 = num1.charAt(i) - '0';
            int newDigit = digit1 * (c - '0') + next;
            next = newDigit/10;
            newDigit = newDigit % 10;
            sb.append(newDigit);
        }
        if (next > 0) sb.append(next);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Q43_test1().add("98", "9");
    }
}
