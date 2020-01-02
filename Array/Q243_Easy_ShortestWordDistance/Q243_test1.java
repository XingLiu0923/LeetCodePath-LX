public class Q243_test1 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1;
        int n = words.length;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) pos1 = i;
            else if (words[i].equals(word2)) pos2 = i;
            if (pos1 >= 0 && pos2 >= 0) minDist = Math.abs(pos1 - pos2) < minDist ? Math.abs(pos1 - pos2) : minDist;
        }
        return minDist;
    }
}
