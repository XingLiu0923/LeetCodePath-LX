import java.util.*;

public class Q170_3_test1 {

    HashMap<String, Integer> movieAndTimes;

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        movieAndTimes = new HashMap<>();
        boolean[] visited = new boolean[friends.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        bfs(id, friends, watchedVideos, level, visited);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.times > o2.times) return 1;
                else if (o1.times < o2.times) return -1;
                else return o1.movie.compareTo(o2.movie);
            }
        });
        for (String each : movieAndTimes.keySet()) {
            priorityQueue.add(new Node(each, movieAndTimes.get(each)));
        }
        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().movie);
        }
        return result;
    }

    private class Node {
        private String movie;
        private int times;

        Node(String s, int t) {
            movie = s; times = t;
        }
    }

    private void bfs(int id, int[][] friends, List<List<String>> videos, int level, boolean[] visited) {
        Queue<Integer> friendsQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        friendsQ.add(id);
        levelQ.add(level);
        visited[id] = true;
        while (!friendsQ.isEmpty()) {
            int curLevel = levelQ.poll();
            int curFriend = friendsQ.poll();
            if (curLevel == 0) {
                for (String s : videos.get(curFriend)) {
                    if (!movieAndTimes.containsKey(s)) movieAndTimes.put(s, 0);
                    int thisTime = movieAndTimes.get(s);
                    movieAndTimes.put(s, thisTime + 1);
                }
            } else {
                for (int each : friends[curFriend]) {
                    if (!visited[each]) {
                        friendsQ.add(each); levelQ.add(curLevel - 1);
                        visited[each] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
