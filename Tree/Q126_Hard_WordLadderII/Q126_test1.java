import java.util.*;

public class Q126_test1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();
        HashMap<String, List<String>> stringNeighbors = new HashMap<>();
        HashMap<String, List<String>> dicToString = new HashMap<>();
        wordList.add(beginWord);
        for (String each : wordList) {
            List<String> neighbors = neighborS(each);
            if (!stringNeighbors.containsKey(each)) stringNeighbors.put(each, neighbors);
            for (String neighbor : neighbors) {
                if (!dicToString.containsKey(neighbor)) dicToString.put(neighbor, new ArrayList<>());
                dicToString.get(neighbor).add(each);
            }
        }
        HashMap<String, List<String>> parents = new HashMap<>();
        HashMap<String, Integer> layers = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        parents.put(beginWord, null);
        layers.put(beginWord, 0);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String curS = queue.poll();
            if (curS == endWord) break;
            int curLayer = layers.get(curS);
            List<String> neighbors = stringNeighbors.get(curS);
            for (String each : neighbors) {
                List<String> nextS = dicToString.get(each);
                for (String s : nextS) {
                    if (!layers.containsKey(s)) {
                        layers.put(s, curLayer + 1);
                        queue.add(s);
                        parents.put(s, new ArrayList<>());
                        parents.get(s).add(curS);
                    } else {
                        if (layers.get(s) == curLayer + 1) {
                            parents.get(s).add(curS);
                        }
                    }
                }
            }
        }
        if (!parents.containsKey(endWord)) return ladders;
        Stack<String> stack = new Stack<>();
        dfs(ladders, stack, parents, endWord);
        return ladders;
    }

    private void dfs(List<List<String>> ladders, Stack<String> stack, HashMap<String, List<String>> parents, String word) {
        if (parents.get(word) == null) {
            stack.push(word);
            List<String> list = new ArrayList<>(stack);
            reverse(list);
            ladders.add(list);
            stack.pop();
            return;
        }
        stack.push(word);
        List<String> curParents = parents.get(word);
        for (String each : curParents) {
            dfs(ladders, stack, parents, each);
        }
        stack.pop();
    }

    private List<String> neighborS(String s) {
        List<String> neighborList = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            chars[i] = '*';
            neighborList.add(String.valueOf(chars));
            chars[i] = c;
        }
        return neighborList;
    }

    private void reverse(List<String> list) {
        int n = list.size();
        int i = 0, j = n - 1;
        while (j > i) {
            swap(list, i++, j--);
        }
    }

    private void swap(List<String> list, int i, int j) {
        String s = list.get(i);
        list.set(i, list.get(j));
        list.set(j, s);
    }
}
