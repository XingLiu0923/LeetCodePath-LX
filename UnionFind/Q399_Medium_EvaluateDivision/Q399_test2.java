import java.util.*;

public class Q399_test2 {
    HashMap<String, List<String>> nextNode = new HashMap<>();
    HashMap<String, List<Double>> nextVal = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        for (int i = 0; i < n; i++) {
            String start = equations.get(i).get(0), end = equations.get(i).get(1);
            addEdge(start, end, values[i]);
        }
        int qN = queries.size();
        double[] result = new double[qN];
        for (int i = 0; i < qN; i++) {
            result[i] = bfs(queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    private void addEdge(String s, String e, double val) {
        if (!nextNode.containsKey(s)) {
            nextNode.put(s, new ArrayList<>()); nextVal.put(s, new ArrayList<>());
            nextNode.get(s).add(s); nextVal.get(s).add(1.0);
        }
        nextNode.get(s).add(e); nextVal.get(s).add(val);
        if (!nextNode.containsKey(e)) {
            nextNode.put(e, new ArrayList<>()); nextVal.put(e, new ArrayList<>());
            nextNode.get(e).add(e); nextVal.get(e).add(1.0);
        }
        nextNode.get(e).add(s);
        if (val == 0) nextVal.get(e).add(val);
        else nextVal.get(e).add(1.0/val);
    }

    private double bfs(String start, String end) {
        if (!nextNode.containsKey(start) || !nextNode.containsKey(end)) return -1.0;
        Queue<String> nodeQ = new LinkedList<>(); Queue<Double> valQ = new LinkedList<>();
        nodeQ.add(start); valQ.add(1.0);
        double result = 1.0;
        while (!nodeQ.isEmpty()) {
            String s = nodeQ.poll(); result = result * valQ.poll();
            if (s == end) return result;
            for (String each : nextNode.get(s)) {
                nodeQ.add(each);
            }
            for (Double each : nextVal.get(s)) {
                valQ.add(each);
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("ab"); list1.add("b");
        List<String> list2 = new ArrayList<>();
        list2.add("b"); list2.add("c");
        List<List<String>> list = new ArrayList<>();
        list.add(list1); // list.add(list2);
        double[] d = new double[1];
        d[0] = 2.0; // d[1] = 3.0;
        List<String> q1 = new ArrayList<>();
        q1.add("ab"); q1.add("b");
        List<String> q2 = new ArrayList<>();
        q2.add("b"); q2.add("a");
        List<String> q3 = new ArrayList<>();
        q3.add("ab"); q3.add("e");
        List<String> q4 = new ArrayList<>();
        q4.add("ab"); q4.add("ab");
        List<String> q5 = new ArrayList<>();
        q5.add("x"); q5.add("x");
        List<List<String>> question = new ArrayList<>();
        question.add(q1); // question.add(q2); question.add(q3); question.add(q4); question.add(q5);
        new Q399_test2().calcEquation(list, d, question);
    }
}
