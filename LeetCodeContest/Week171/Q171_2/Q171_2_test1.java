import java.util.List;

public class Q171_2_test1 {
    public int minFlips(int a, int b, int c) {
        int[] aBin = intToBin(a), bBin = intToBin(b), cBin = intToBin(c);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((aBin[i] | bBin[i]) == cBin[i]) continue;
            if ((aBin[i] | bBin[i]) == 0) count++;
            else {
                count += (aBin[i] + bBin[i]);
            }
        }
        return count;
    }

    private int[] intToBin(int a) {
        int[] bin = new int[32];
        int count = 0;
        while (a > 0) {
            if (a % 2 == 1) bin[count] = 1;
            count++; a /= 2;
        }
        return bin;
    }

    public static void main(String[] args) {
        new Q171_2_test1().minFlips(4, 2, 7);
    }
}
