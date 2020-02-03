public class Q727_test1 {
    public String minWindow(String S, String T) {
        int nS = S.length(), nT = T.length();
        int pointT = 0;
        int leftS = 0, rightS = 0;
        int minLength = Integer.MAX_VALUE, begin = 0, end = 0;
        while (rightS < nS) {
            char cS = S.charAt(rightS), cT = T.charAt(pointT);
            if (cS != cT) { rightS++; continue; }
            rightS++;
            if (pointT != nT - 1) { pointT++; continue; }
            leftS = rightS - 1;
            while (pointT > -1) {
                if (S.charAt(leftS) != T.charAt(pointT)) { leftS--; continue; }
                pointT--; leftS--;
            }
            int length = rightS - leftS - 1;
            if (length < minLength) {
                minLength = length;
                begin = leftS + 1; end = rightS;
            }
            pointT = 0;
        }
        return S.substring(begin, end);
    }

    public static void main(String[] args) {
        new Q727_test1().minWindow("abcdebdde", "bde");
    }
}
