import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Q223_test1 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        if ((C <= E) || (G <= A) || (D <= F) || (H <= B)) return area1 + area2;
        int intersectA = Math.max(A, E), intersectB = Math.max(B, F);
        int intersectC = Math.min(C, G), intersectD = Math.min(D, H);
        return area1 + area2 - (intersectC - intersectA) * (intersectD - intersectB);
    }
}
