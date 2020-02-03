import java.util.Arrays;
import java.util.PriorityQueue;

public class Q630_test1 {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if (n == 0) return 0;
        Arrays.sort(courses, ((o1, o2) -> (o1[1] - o2[1])));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            if (totalTime + courses[i][0] <= courses[i][1]) {
                totalTime += courses[i][0];
                priorityQueue.add(courses[i]);
            } else {
                if (priorityQueue.isEmpty()) continue;
                int[] removeCourse = priorityQueue.peek();
                if (removeCourse[0] > courses[i][0]) {
                    priorityQueue.poll();
                    priorityQueue.add(courses[i]);
                    totalTime = totalTime - removeCourse[0] + courses[i][0];
                }
            }
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        new Q630_test1().scheduleCourse(new int[][]{{100,2},{32,50}});
    }
}
