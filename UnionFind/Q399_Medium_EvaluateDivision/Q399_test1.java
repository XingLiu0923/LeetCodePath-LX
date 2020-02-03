import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q399_test1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        int questionN = queries.size();
        double[] answers = new double[questionN];
        for (int i = 0; i < questionN; i++) {
            answers[i] = uf.findValue(queries.get(i).get(0), queries.get(i).get(1));
        }
        return answers;
    }

    private class UnionFind {
        HashMap<String, String> nextPoint;
        HashMap<String, Integer> size;
        HashMap<String, Double> value;
        private int count;

        UnionFind() {
            nextPoint = new HashMap<>();
            size = new HashMap<>();
            value = new HashMap<>();
            count = 0;
        }

        protected double findValue(String p) {
            findRoot(p);
            return value.get(p);
        }

        protected double findValue(String p, String q) {
            if (!connected(p, q)) return -1;
            return findValue(p)/findValue(q);
        }

        protected String findRoot(String p) {
            double val = 1;
            String t = p;
            while (nextPoint.get(p) != p) {
                val = val * value.get(p);
                p = nextPoint.get(p);
            }
            nextPoint.put(t, p);
            value.put(t, val);
            return p;
        }

        protected boolean connected(String p, String q) {
            if (!nextPoint.containsKey(p) || !nextPoint.containsKey(q)) return false;
            return findRoot(p).equals(findRoot(q));
        }

        protected void union(String p, String q, double v) {
            if (!nextPoint.containsKey(p)) {
                nextPoint.put(p, p); value.put(p, 1.0); size.put(p, 1); count++;
            }
            if (!nextPoint.containsKey(q)) {
                nextPoint.put(q, q); value.put(q, 1.0); size.put(q, 1); count++;
            }
            if (connected(p, q)) return;
            String pRoot = findRoot(p), qRoot = findRoot(q);
            double pValue = findValue(p), qValue = findValue(q);
            if (size.get(pRoot) < size.get(qRoot)) {
                nextPoint.put(pRoot, qRoot);
                value.put(pRoot, qValue * v / pValue);
            } else {
                nextPoint.put(qRoot, pRoot);
                value.put(qRoot, pValue / (qValue * v));
            }
            size.put(qRoot, size.get(pRoot) + size.get(qRoot));
            count--;
        }
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("a"); list1.add("b");
        List<String> list2 = new ArrayList<>();
        list2.add("b"); list2.add("c");
        List<List<String>> list = new ArrayList<>();
        list.add(list1); list.add(list2);
        double[] d = new double[2];
        d[0] = 2.0; d[1] = 3.0;
        List<String> q1 = new ArrayList<>();
        q1.add("a"); q1.add("c");
        List<String> q2 = new ArrayList<>();
        q2.add("b"); q2.add("a");
        List<String> q3 = new ArrayList<>();
        q3.add("a"); q3.add("3");
        List<List<String>> question = new ArrayList<>();
        question.add(q2); question.add(q2); question.add(q3);
        new Q399_test1().calcEquation(list, d, question);
    }

}
