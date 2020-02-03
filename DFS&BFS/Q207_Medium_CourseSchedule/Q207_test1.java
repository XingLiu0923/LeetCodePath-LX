import java.util.ArrayList;
import java.util.List;

public class Q207_test1 {
    private enum Status {
        UNDISCOVERED, DISCOVERED, VISITED
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if (n == 0) return true;
        List<Integer>[] neighbors = new List[numCourses];
        Status[] VStatus = new Status[numCourses];
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<>();
            VStatus[i] = Status.UNDISCOVERED;
        }
        for (int i = 0; i < n; i++) neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        for (int i = 0; i < numCourses; i++) {
            if (VStatus[i] == Status.UNDISCOVERED) {
                if (!dfs(i, neighbors, VStatus)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, List<Integer>[] neighbors, Status[] VStatus) {
        VStatus[i] = Status.DISCOVERED;
        for (int each : neighbors[i]) {
            if (VStatus[each] == Status.DISCOVERED) return false;
            else if (VStatus[each] == Status.UNDISCOVERED) {
                if (!dfs(each, neighbors, VStatus)) return false;
            }
        }
        VStatus[i] = Status.VISITED;
        return true;
    }

    public static void main(String[] args) {
        int[][] p = new int[][] {{1, 0}};
        new Q207_test1().canFinish(2, p);
    }
}
