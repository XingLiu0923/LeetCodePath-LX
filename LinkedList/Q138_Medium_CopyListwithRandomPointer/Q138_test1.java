import java.util.HashMap;

public class Q138_test1 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!hashMap.containsKey(head)) hashMap.put(head, new Node(head.val));
        Node copy = hashMap.get(head);
        copy.next = copyRandomList(head.next);
        if (head.random == null) copy.random = null;
        else {
            if (!hashMap.containsKey(head.random)) hashMap.put(head.random, new Node(head.random.val));
            copy.random = hashMap.get(head.random);
        }
        return copy;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b; b.next = null;
        a.random = b; b.random = b;
        new Q138_test1().copyRandomList(a);
    }
}
