import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q210_test1 {
    private enum Status {
        UNDISCOVERD, DISCOVERD, VISITED
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] neighbors = new List[numCourses];
        Status[] VStatus = new Status[numCourses];
        Stack<Integer> path = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            neighbors[i] = new ArrayList<>();
            VStatus[i] = Status.UNDISCOVERD;
        }
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        for (int i = 0; i < numCourses; i++) {
            if (VStatus[i] == Status.UNDISCOVERD) {
                if (!dfs(i, neighbors, VStatus, path)) return new int[]{};
            }
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = path.pop();
        }
        return order;
    }

    private boolean dfs(int v, List<Integer>[] neighbors, Status[] VStatus, Stack<Integer> stack) {
        VStatus[v] = Status.DISCOVERD;
        for (int each : neighbors[v]) {
            if (VStatus[each] == Status.DISCOVERD) return false;
            if (VStatus[each] == Status.UNDISCOVERD) {
                if (!dfs(each, neighbors, VStatus, stack)) return false;
            }
        }
        stack.push(v);
        VStatus[v] = Status.VISITED;
        return true;
    }
}
