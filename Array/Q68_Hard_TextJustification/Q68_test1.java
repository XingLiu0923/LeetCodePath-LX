import java.util.ArrayList;
import java.util.List;

public class Q68_test1 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int i = 0, j = 0;
        List<String> sList = new ArrayList<>();
        while (j < n) {
            int countLength = 0, num = 0;
            while (j < n && countLength + words[j].length() <= maxWidth - num) {
                countLength += words[j++].length(); num++;
            }
            if (j < n) sList.add(middleSentence(words, i, j, maxWidth, countLength));
            else sList.add(leftSentence(words, i, j, maxWidth));
            i = j;
        }
        return sList;
    }

    private String middleSentence(String[] words, int i, int j, int maxWidth, int countLength) {
        int gapLength = maxWidth - countLength;
        int gapNum = Math.max(1, j - i - 1);
        int baseLength = gapLength / gapNum, plusLength = gapLength % gapNum;
        StringBuilder sb = new StringBuilder();
        for (int k = i; k < j; k++) {
            sb.append(words[k]);
            if (gapNum-- > 0) {
                int count = 0;
                while (count++ < baseLength) sb.append(" ");
                if (plusLength > 0) { sb.append(" "); plusLength--; }
            }
        }
        return sb.toString();
    }

    private String leftSentence(String[] words, int i, int j, int maxWith) {
        StringBuilder sb = new StringBuilder();
        for (int k = i; k < j; k++) {
            sb.append(words[k]);
            if (k < j - 1) sb.append(" ");
        }
        while (sb.length() < maxWith) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] ss = new String[] {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        new Q68_test1().fullJustify(ss, 16);
    }
}
