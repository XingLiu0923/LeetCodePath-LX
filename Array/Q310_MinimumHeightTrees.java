import java.util.*;

public class Q310_MinimumHeightTrees {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] dist;
    private int farestP;
    private int farestQ;

    private class Graph {
        private List<Integer>[] V;
        public Graph(int n) {
            V = new List[n];
            for (int i = 0; i < n; i++) {
                V[i] = new ArrayList<Integer>();
            }
        }
        public void addEdges(int i, int j) {
            V[i].add(j);
            V[j].add(i);
        }
        public Iterable<Integer> adj(int x) {
            return V[x];
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        marked = new boolean[n];
        edgeTo = new int[n];
        dist = new int[n];
        Graph G = new Graph(n);

        for (int i = 0; i < edges.length; i++) {
            G.addEdges(edges[i][0], edges[i][1]);
        }

        farestP = bfs1(G, 0);
        farestQ = bfs2(G, farestP);

        List<Integer> center = new ArrayList<Integer>();
        int count = 0;
        int point = farestQ;
        while (count < dist[farestQ]/2) {
            point = edgeTo[point];
            count++;
        }
        center.add(point);
        if (dist[farestQ] % 2 == 1) {
            center.add(edgeTo[point]);
        }
        return center;
    }

    private int bfs1(Graph G, int s) {
        marked[s] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        int x = s;
        while (!q.isEmpty()) {
            x = q.poll();
            for (int w : G.adj(x)) {
                if (!marked[w]) {
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        return x;
    }

    private int bfs2(Graph G, int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        dist[v] = 0;
        edgeTo[v] = v;
        int x = v;
        while (!q.isEmpty()) {
            x = q.poll();
            for (int w : G.adj(x)) {
                if (w != edgeTo[x]) {
                    edgeTo[w] = x;
                    q.add(w);
                    dist[w] = dist[x] + 1;
                }
            }
        }
        return x;
    }
}
