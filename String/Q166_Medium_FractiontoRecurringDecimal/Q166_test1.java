import java.math.BigInteger;
import java.util.HashMap;

public class Q166_test1 {
    HashMap<Long, Integer> hashMap = new HashMap<>();
    int pos = -1;
    public String fractionToDecimal(int numerator, int denominator) {
        long nL = (long) numerator, dL = (long) denominator;
        if (nL % dL == 0) return String.valueOf(nL / dL);
        String result = "";
        if ((nL < 0 && dL > 0) || (nL > 0 && dL < 0)) result += "-";

        if (nL < 0) nL = -nL; if (dL < 0) dL = -dL;
        result += (nL/dL);
        result += ".";
        nL %= dL;
        result += fractionToDecimal(nL, dL, 0);
        return result;
    }

    private String fractionToDecimal(long nl, long dl, int position) {
        nl = nl * 10;
        if (hashMap.containsKey(nl)) { pos = hashMap.get(nl); return ")"; }
        String thisPoint = Integer.toString((int)(nl/dl));
        hashMap.put(nl, position);
        long res = nl % dl;
        if (res == 0) return thisPoint;
        thisPoint = thisPoint + fractionToDecimal(res, dl, position + 1);
        if (pos == position) thisPoint = "(" + thisPoint;
        return thisPoint;
    }

    public static void main(String[] args) {
        System.out.println(1001 % 26);
        new Q166_test1().fractionToDecimal(2, 3);
    }
}