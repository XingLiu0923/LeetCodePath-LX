import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q133_test1 {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Integer, Node> hashMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node cloneNode = new Node(node.val, new ArrayList<>());
        hashMap.put(node.val, cloneNode);
        for (Node each : node.neighbors) {
            if (!hashMap.containsKey(each.val)) cloneGraph(each);
            cloneNode.neighbors.add(hashMap.get(each.val));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        Node a = new Node(1, new ArrayList<>());
        Node b = new Node(2, new ArrayList<>());
        Node c = new Node(3, new ArrayList<>());
        Node d = new Node(4, new ArrayList<>());
        a.neighbors.add(b); a.neighbors.add(d);
        b.neighbors.add(a); b.neighbors.add(c);
        c.neighbors.add(d); c.neighbors.add(b);
        d.neighbors.add(a); d.neighbors.add(c);
        new Q133_test1().cloneGraph(a);
    }
}
