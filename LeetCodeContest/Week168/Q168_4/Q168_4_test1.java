import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q168_4_test1 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        HashSet<Integer> Boxes = new HashSet<>();
        HashSet<Integer> Keys = new HashSet<>();
        Queue<Integer> boxesHold = new LinkedList<>();
        for (Integer each : initialBoxes) {
            if (status[each] == 1) boxesHold.add(each);
            else Boxes.add(each);
        }
        int candySum = 0;
        while (!boxesHold.isEmpty()) {
            int currBox = boxesHold.poll();
            candySum += candies[currBox];
            for (Integer nextBox : containedBoxes[currBox]) {
                if (status[nextBox] == 1) boxesHold.add(nextBox);
                else if (Keys.contains(nextBox)) {
                    boxesHold.add(nextBox);
                    Boxes.remove(nextBox);
                }
                else { Boxes.add(nextBox); }
            }
            for (Integer nextKey : keys[currBox]) {
                if (Keys.contains(nextKey)) continue;
                if (Boxes.contains(nextKey)) {
                    boxesHold.add(nextKey);
                    Boxes.remove(nextKey);
                }
                else { Keys.add(nextKey); }
            }
        }
        return candySum;
    }
}
