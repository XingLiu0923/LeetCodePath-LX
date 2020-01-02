import java.util.ArrayList;
import java.util.List;

public class Q323_test2 {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] E = new List[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            E[i] = new ArrayList<>();
        }

        int ENumber = edges.length;
        for (int i = 0; i < ENumber; i++) {
            E[edges[i][0]].add(edges[i][1]);
            E[edges[i][1]].add(edges[i][0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, E, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int v, List<Integer>[] E, boolean[] visited) {
        visited[v] = true;
        for (Integer u : E[v]) {
            if (!visited[u]) {
                dfs(u, E, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[1][2];
        edges[0][0] = 1;    edges[0][1] = 0;
        new Q323_test2().countComponents(2, edges);
    }

}
