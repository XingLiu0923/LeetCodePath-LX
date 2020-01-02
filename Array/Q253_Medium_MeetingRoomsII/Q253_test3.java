import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Vector;

public class Q253_test3 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Vector<int[]>> rooms = new PriorityQueue<>((roo1, roo2) -> (roo1.lastElement()[1] - roo2.lastElement()[1]));
        for (int i = 0; i < n; i++) {
            if (!rooms.isEmpty() && rooms.peek().lastElement()[1] <= intervals[i][0]) {
                Vector<int[]> room = rooms.poll();
                room.add(intervals[i]);
                rooms.add(room);
            } else {
                Vector<int[]> newRoom = new Vector<>();
                newRoom.add(intervals[i]);
                rooms.add(newRoom);
            }
        }
        return rooms.size();
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{9,10},{4,9},{4,17}};
        new Q253_test3().minMeetingRooms(a);
    }
}
