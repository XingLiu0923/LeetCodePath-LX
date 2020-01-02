import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.*;

public class Q332_test1 {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> pathList = new ArrayList<>();
        if (tickets.isEmpty()) return pathList;
        HashMap<String, Integer> hashMap = new HashMap<>();
        MatrixGraph graph = new MatrixGraph();
        for (List<String> each : tickets) {
            String from = each.get(0); String to = each.get(1);
            if (!hashMap.containsKey(from)) {
                hashMap.put(from, graph.vSize());
                graph.insert(from);
            }
            if (!hashMap.containsKey(to)) {
                hashMap.put(to, graph.vSize());
                graph.insert(to);
            }
            int fromv = hashMap.get(from), tov = hashMap.get(to);
            graph.insert(fromv, tov);
        }
        int startv = hashMap.get("JFK");
        Stack<String> path = graph.eulersort(startv);
        while (!path.isEmpty()) pathList.add(path.pop());
        return pathList;
    }

    protected enum VStatus {
        UNDISCOVERED, DISCOVERED;
    }

    private enum EType {
        UNDERTERMINED, TREE, CROSS, FORWAD, BACKWARD;
    }

    private class MatrixGraph {
        class Vertex {
            String data; VStatus status;
            int inDegree, outDegree;
            int parent;

            Vertex(String s) {
                data = s; status = VStatus.UNDISCOVERED;
                inDegree = outDegree = 0;
                parent = -1;
            }
        }

        class Edge {
            int num;
            Edge() {
                num = 1;
            }
        }

        Vector<Vertex> V;   int n;
        Vector<Vector<Edge>> E; int e;

        MatrixGraph() {
            n = e = 0;
            V = new Vector<>();
            E = new Vector<>();
        }

        public int vSize() {
            return n;
        }

        public void insert(int i, int j) {
            if (E.get(i).get(j) == null) E.get(i).set(j, new Edge());
            else E.get(i).get(j).num++;
            e++;
            V.get(i).outDegree++;
            V.get(j).inDegree++;
        }

        public int insert(String v) {
            for (int i = 0; i < n; i++) {
                E.get(i).add(null);
            }
            n++;
            Vector<Edge> newEdge = new Vector<>();
            for (int i = 0; i < n; i++) {
                newEdge.add(null);
            }
            E.add(newEdge);
            V.add(new Vertex(v));
            return n;
        }

        public boolean exist(int i, int j) {
            return i > -1 && i < n && j > -1 && j < n && E.get(i).get(j) != null && E.get(i).get(j).num > 0;
        }

        private int nextNbr(int i, int j) {
            while (j > -1 && !exist(i, --j));
            return j;
        }

        private int firstNbr(int i) {
            return nextNbr(i, n);
        }

        public Stack<String> eulersort(int k) {
            Stack<String> stack = new Stack<>();
            EulerSort(k, stack);
            return stack;
        }

        public void EulerSort(int v, Stack<String> s) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (V.get(a).data.compareTo(V.get(b).data)));
            for (int u = firstNbr(v); u > -1; u = nextNbr(v, u)) {
                priorityQueue.add(u);
            }
            while (!priorityQueue.isEmpty()) {
                int u = priorityQueue.poll();
                if (E.get(v).get(u).num > 0) {
                    E.get(v).get(u).num--;
                    EulerSort(u, s);
                }
            }
            s.push(V.get(v).data);
        }
    }
}
