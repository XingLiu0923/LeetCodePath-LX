import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q109_test2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowLast = null;
        while (fast != null && fast.next != null) {
            slowLast = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slowLast != null) slowLast.next = null;
        TreeNode root = new TreeNode(slow.val);
        if (slow != head) root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
