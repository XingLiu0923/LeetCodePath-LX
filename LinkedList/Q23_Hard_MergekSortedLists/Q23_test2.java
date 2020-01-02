public class Q23_test2 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        while (n > 1) {
            int i = 0, j = n - 1;
            while (i < j) {
                lists[i] = mergeTowList(lists, i++, j--);
            }
            n = i > j ?  i : i + 1;
        }
        return lists[0];
    }

    private ListNode mergeTowList(ListNode[] lists, int i, int j) {
        ListNode first = new ListNode(-1);
        ListNode prev = first;
        while (prev != null) {
            if (lists[i] == null) { prev.next = lists[j]; break; }
            else if (lists[j] == null) { prev.next = lists[i]; break; }
            else if (lists[j].val < lists[i].val) { prev.next = lists[j]; lists[j] = lists[j].next; prev = prev.next; }
            else { prev.next = lists[i]; lists[i] = lists[i].next; prev = prev.next; }
        }
        return first.next;
    }
}
