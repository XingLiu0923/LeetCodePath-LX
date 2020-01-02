public class Q245_test1 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int pos1 = -1, pos2 = -1;
        int minDist = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    if (pos1 <= pos2) pos1 = i;
                    else pos2 = i;
                    if (pos1 != -1 && pos2 != -1) {
                        int dist = Math.abs(pos1 - pos2);
                        minDist = dist < minDist ? dist : minDist;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) pos1 = i;
                else if (words[i].equals(word2)) pos2 = i;
                if (pos1 != -1 && pos2 != -1) {
                    int dist = Math.abs(pos1 - pos2);
                    minDist = dist < minDist ? dist : minDist;
                }
            }
        }
        return minDist;
    }
}
