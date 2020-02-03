import java.util.LinkedList;

public class Q12_test1 {
    public String intToRoman(int num) {
        String result = "";
        int base = 1;
        while (num > 0) {
            int t = num % 10;
            if (t >= 1 && t <= 3) {
                if (base == 1) result = repeat('I', t) + result;
                else if (base == 2) result = repeat('X', t) + result;
                else if (base == 3) result = repeat('C', t) + result;
                else result = repeat('M', t) + result;
            } else if (t == 4) {
                if (base == 1) result = "IV" + result;
                else if (base == 2) result = "XL" + result;
                else if (base == 3) result = "CD" + result;
            } else if (t == 5) {
                if (base == 1) result = "V" + result;
                else if (base == 2) result = "L" + result;
                else if (base == 3) result = "D" + result;
            } else if (t >= 6 && t <= 8) {
                if (base == 1) result = "V" + repeat('I', t - 5) + result;
                else if (base == 2) result = "L" + repeat('X', t - 5) + result;
                else result = "D" + repeat('C', t - 5) + result;
            } else if (t == 9) {
                if (base == 1) result = "IX" + result;
                else if (base == 2) result = "XC" + result;
                else if (base == 3) result = "CM" + result;
            }
            base++;
            num = num / 10;
        }
        return result;
    }

    private String repeat(char c, int times) {
        String s = "";
        while (times-- > 0) s = s + c;
        return s;
    }

    public static void main(String[] args) {
        new Q12_test1().intToRoman(58);
    }
}
