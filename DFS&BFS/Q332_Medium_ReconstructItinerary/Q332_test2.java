import java.util.*;

public class Q332_test2 {
    HashMap<String, PriorityQueue<String>> hashMap;

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> pathList = new ArrayList<>();
        if (tickets.isEmpty()) return pathList;

        hashMap = new HashMap<>();
        for (List<String> each : tickets) {
            String from = each.get(0); String to = each.get(1);
            if (!hashMap.containsKey(from)) hashMap.put(from, new PriorityQueue<>());
            if (!hashMap.containsKey(to)) hashMap.put(to, new PriorityQueue<>());
            PriorityQueue fromQueue = hashMap.get(from);
            fromQueue.add(to);
        }
        dfs("JFK", pathList);
        return pathList;
    }

    private void dfs(String k, List<String> path) {
        PriorityQueue<String> pq = hashMap.get(k);
        while (!pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, path);
        }
        path.add(0, k);
    }
}
