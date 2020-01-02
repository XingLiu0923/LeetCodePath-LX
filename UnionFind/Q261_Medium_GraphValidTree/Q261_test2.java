import java.util.ArrayList;
import java.util.List;

public class Q261_test2 {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] E = new List[n];        // 记录连接的边；
        for (int i = 0; i < n; i++) {
            E[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];     // 记录状态，本质上就是点。
        int[] parent = new int[n];

        int ENumber = edges.length;
        for (int i = 0; i < ENumber; i++) {
            E[edges[i][0]].add(edges[i][1]);
            E[edges[i][1]].add(edges[i][0]);
        }
        boolean tree = dfs(0, E, visited, parent);
        if (tree) {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) tree = false;
            }
        }
        return tree;
    }

    private boolean dfs(int v, List<Integer>[] E, boolean[] visited, int[] parent) {
        visited[v] = true;
        for (Integer u : E[v]) {
            if (!visited[u]) {
                parent[u] = v;
                if (!dfs(u, E, visited, parent)) return false;
            } else {
                if (u != parent[v]) return false;
            }
        }
        return true;
    }

}
