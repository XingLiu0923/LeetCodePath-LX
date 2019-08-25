public class Q914_test1 {
    public static int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    public static int max(int a, int b) {
        if (a < b) return b;
        else return a;
    }

    //求最大公约数；
    public static int gcd(int a, int b) {
        int divisor = min(a, b);
        int dividend = max(a, b);
        int temp = 0;
        while (divisor > 1) {
            if (dividend % divisor == 0) break;
            temp = divisor;
            divisor = dividend % divisor;
            dividend = temp;
        }
        return divisor;
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] mark = new int[10000];        //作为数组的桶；
        for (int i = 0; i < deck.length; i++) {     //统计各个数字出现的次数；
            mark[deck[i]]++;
        }
        int gcd = -1;
        for (int i = 0; i < mark.length; i++) {     //用gcd记录gcd值与当前值的最大公约数，一旦该值等于1，则说明两数互制，不可能有x存在；
            if (mark[i] == 0) continue;
            if (gcd < 0) gcd = mark[i];
            gcd = gcd(gcd, mark[i]);
            if (gcd == 1) break;
        }
        if (gcd > 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] test = { 1 };
        Q914_test1 test1 = new Q914_test1();
        System.out.println(test1.hasGroupsSizeX(test));
    }
}
