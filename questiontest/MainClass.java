import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static ListNode sortList(ListNode head) {
        int n = getsize(head);
        return sortList(head, 0, n - 1);
    }

    public static ListNode sortList(ListNode head, int lo, int hi) {
        if (lo >= hi) return head;
        int mid = (lo + hi)/2;
        ListNode headlo = head;
        ListNode headmid = headlo;
        ListNode headhi;
        for (int i = lo; i < mid; i++) {
            headmid = headmid.next;
        }
        headhi = headmid.next;
        headmid.next = null;
        headmid = headhi;
        for (int i = mid + 1; i < hi; i++) {
            headmid = headmid.next;
        }
        headmid.next = null;
        headlo = sortList(headlo, lo, mid);
        headhi = sortList(headhi, mid + 1, hi);
        return mergelist(headlo, headhi, lo, hi);
    }

    public static ListNode mergelist(ListNode head1, ListNode head2, int lo, int hi) {
        ListNode headaux;
        ListNode first;
        if (head2.val < head1.val) headaux = head2;
        else headaux = head1;
        first = headaux;
        for (int k = lo; k < hi; k++) {
            if (headaux.next == null) {
                if (headaux == head1) {
                    headaux.next = head2;
                    break;
                }
                else {
                    headaux.next = head1;
                    break;
                }
            }

            else if (headaux == head1) {
                if (head2.val < headaux.next.val) {
                    head1 = head1.next;
                    headaux.next = head2;
                    headaux = headaux.next;
                }
                else {
                    headaux = headaux.next;
                    head1 = headaux;
                }
            }
            else if (headaux == head2) {
                if (head1.val < headaux.next.val) {
                    head2 = head2.next;
                    headaux.next = head1;
                    headaux = headaux.next;
                }
                else {
                    headaux = headaux.next;
                    head2 = headaux;
                }
            }
        }
        return first;
    }

    public static int getsize(ListNode head) {
        ListNode pos = head;
        if (pos == null) return 0;
        int size = 1;
        while (pos.next != null) {
            pos = pos.next;
            size++;
        }
        return size;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().sortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}