import java.util.HashMap;

public class Q138_test2 {
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

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node x = head;
        while (x != null) {
            Node copy = new Node(x.val);
            copy.next = x.next;
            x.next = copy;
            x = copy.next;
        }
        x = head;
        while (x != null) {
            if (x.random == null) x.next.random = null;
            else x.next.random = x.random.next;
            x = x.next.next;
        }
        Node newHead = head.next;
        x = head;
        while (x != null) {
            Node fast = x.next;
            if (fast == null) x.next = null;
            else x.next = x.next.next;
            x = fast;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b; b.next = null;
        a.random = b; b.random = b;
        new Q138_test2().copyRandomList(a);
    }
}
