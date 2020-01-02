import java.util.Arrays;
import java.util.Vector;

public class Q253_test2 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Vector<Vector<int[]>> rooms = new Vector<>();
        for (int i = 0; i < n; i++) {
            boolean setdown = false;
            for (Vector<int[]> room : rooms) {
                int[] lastTime = room.lastElement();
                if (lastTime[1] <= intervals[i][0]) {
                    setdown = true; room.add(intervals[i]);
                    break;
                }
            }
            if (!setdown) {
                Vector<int[]> newRoom = new Vector<>();
                newRoom.add(intervals[i]);
                rooms.add(newRoom);
            }
        }
        return rooms.size();
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{9,10},{4,9},{4,17}};
        new Q253_test2().minMeetingRooms(a);
    }
}
