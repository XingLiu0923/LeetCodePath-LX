import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class GraphMatrix {
    protected enum VStatus {
        UNDISCOVERED, DISCOVERED, VISITED;
    }

    public class Vertex {
        int data, inDegree, outDegree; VStatus status;
        int dTime, fTime;
        int parent;
        int priority;

        Vertex(int d) {
            data = d; inDegree = 0; outDegree = 0;
            status = VStatus.UNDISCOVERED; dTime = -1; fTime = -1; parent = -1; priority = Integer.MAX_VALUE;
        }
    }

    protected enum EType {
        UNDETERMINED, TREE, CROSS, FORWARD, BACKWARD;
    }

    private class Edge {
        int data; int weight; EType type;

        Edge(int e, int w) {
            data = e; w = weight; type = EType.UNDETERMINED;
        }
    }

    private Vector<Vertex> V;
    private Vector<Vector<Edge>> E;
    private int n;      // 顶点总数；
    private int e;      // 边总数；

    public GraphMatrix() {
        n = e = 0;
        V = new Vector<>();
        E = new Vector<>();
    }

    public int vertex(int i) {
        return V.get(i).data;
    }

    public int inDegree(int i) {
        return V.get(i).inDegree;
    }

    public int outDegree(int i) {
        return V.get(i).outDegree;
    }

    public VStatus status(int i) {
        return V.get(i).status;
    }

    public int dTime(int i) {
        return V.get(i).dTime;
    }

    public int fTime(int i) {
        return V.get(i).fTime;
    }

    public int parent(int i) {
        return V.get(i).parent;
    }

    public int priority(int i) {
        return V.get(i).priority;
    }

    public boolean exist(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < 0 && E.get(i).get(j) != null;
    }

    public int edge(int i, int j) {
        return E.get(i).get(j).data;
    }

    public EType type(int i, int j) {
        return E.get(i).get(j).type;
    }

    public int weight(int i, int j) {
        return E.get(i).get(j).weight;
    }

    public int firstNbr(int i) {
        return nextNbr(i, n);
    }

    public int nextNbr(int i, int j) {
        while (j > -1 && !exist(i, --j));
        return j;
    }

    public void insert(int edge, int weight, int i, int j) {
        if (i >= n || j >= n || exist(i, j)) return;
        e++;
        E.get(i).set(j, new Edge(edge, weight));
        V.get(i).outDegree++;
        V.get(j).inDegree++;
    }

    public int insert(int vertex) {
        for (int i = 0; i < n; i++) {
            E.get(i).add(null);
        }
        n++;
        Vector<Edge> tmp = new Vector<>();
        for (int i = 0; i < n; i++) {
            tmp.add(null);
        }
        E.add(tmp);
        V.add(new Vertex(vertex));
        return n;
    }

    public int remove(int i, int j) {
        int tmp = E.get(i).get(j).data;
        E.get(i).set(j, null);
        e--;
        V.get(i).outDegree--;
        V.get(j).inDegree--;
        return tmp;
    }

    public int remove(int i) {
        for (int j = 0; j < n; j++) {
            if (exist(i, j)) { e--; V.get(j).inDegree--; }
        }
        E.remove(i);
        n--;
        for (int j = 0; j < n; j++) {
            if (E.get(j).get(i) != null) { e--; V.get(j).outDegree--; }
            E.get(j).remove(i);
        }
        int tmp = V.get(i).data;
        V.remove(i);
        return tmp;
    }

    private void BFS(int v, int[] clock) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);   V.get(v).status = VStatus.DISCOVERED;
        while (!q.isEmpty()) {
            v = q.remove();
            V.get(v).dTime = clock[0]++;
            for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
                if (status(u) == VStatus.UNDISCOVERED) {
                    q.add(u);
                    V.get(u).status = VStatus.DISCOVERED; V.get(u).parent = v;
                    E.get(v).get(u).type = EType.TREE;
                } else {
                    E.get(v).get(u).type = EType.CROSS;
                }
            }
            V.get(v).status = VStatus.VISITED;
        }
    }

    public void bfs(int s) {
        int[] clock = new int[1];
        clock[0] = 0;
        int count = 0;
        for (int v = s; count < n; v = (v++) % n, count++) {
            if (V.get(v).status == VStatus.UNDISCOVERED) BFS(v, clock);
        }
    }

    private void DFS(int v, int[] clock) {
        V.get(v).status = VStatus.DISCOVERED;
        V.get(v).dTime = clock[0]++;
        for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
            if (status(u) == VStatus.UNDISCOVERED) {
                E.get(v).get(u).type = EType.TREE;
                V.get(u).parent = v;
                DFS(u, clock);
            } else if (status(u) == VStatus.DISCOVERED) {
                E.get(v).get(u).type = EType.BACKWARD;
            } else {
                E.get(v).get(u).type = (V.get(v).dTime < V.get(u).dTime) ? EType.FORWARD : EType.CROSS;
            }
        }
        V.get(v).fTime = clock[0]++; V.get(v).status = VStatus.VISITED;
    }

    public void dfs(int s) {
        int[] clock = new int[1];
        clock[0] = 0;
        for (int v = s, count = 0; count < n; count++, v = (v++) % n) {
            if (status(v) == VStatus.DISCOVERED) DFS(v, clock);
        }
    }

    private boolean TSort(int v, int[] clock, Stack<Integer> s) {
        V.get(v).status = VStatus.DISCOVERED;
        V.get(v).dTime = clock[0]++;
        for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
            if (status(u) == VStatus.UNDISCOVERED) {
                V.get(u).parent = v;
                E.get(v).get(u).type = EType.TREE;
                TSort(v, clock, s);
            } else if (status(u) == VStatus.DISCOVERED) {
                E.get(v).get(u).type = EType.BACKWARD; return false;
            } else {
                E.get(v).get(u).type = (V.get(v).dTime < V.get(u).dTime) ? EType.FORWARD : EType.CROSS;
            }
        }
        V.get(v).status = VStatus.VISITED; V.get(v).fTime = clock[0]++;
        return true;
    }

    public Stack<Integer> tsort(int s) {
        Stack<Integer> stack = new Stack<>();
        int[] clock = new int[1];
        clock[0] = 0;
        for (int count = 0, v = s; count < n; count++, v = (v + 1) % n) {
            if (status(v) == VStatus.UNDISCOVERED && !TSort(v, clock, stack)) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                break;
            }
        }
        return stack;
    }

    private void BCC(int v, int[] clock, Stack<Integer> s) {
        s.push(v);
        V.get(v).status = VStatus.DISCOVERED;
        V.get(v).dTime = clock[0]++;
        V.get(v).fTime = dTime(v);
        for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
            if (status(u) == VStatus.UNDISCOVERED) {
                E.get(v).get(u).type = EType.TREE;
                V.get(u).parent = v;
                BCC(v, clock, s);
                if (fTime(u) < dTime(v)) V.get(v).fTime = Math.min(fTime(v), fTime(u));
                else {
                    while (u != s.pop());
                }
            } else if (status(u) == VStatus.DISCOVERED) {
                E.get(v).get(u).type = EType.BACKWARD;
                if (u != parent(v)) V.get(v).fTime = Math.min(fTime(v), dTime(u));
            } else {
                E.get(v).get(u).type = (dTime(v) < dTime(u)) ? EType.FORWARD : EType.CROSS;
            }
        }
    }

    public void bcc(int s) {
        Stack<Integer> S = new Stack<>();
        int[] clock = new int[1];
        clock[0] = 0;
        for (int v = s, count = 0; count < n; s = (s + 1) % n, count++) {
            if (status(v) == VStatus.UNDISCOVERED) BCC(v, clock, S);
        }
    }

    public static void main(String[] args) {
        GraphMatrix gm = new GraphMatrix();
        gm.insert(4);
        gm.insert(3);
        gm.insert(1, 1, 0, 1);
    }
}
