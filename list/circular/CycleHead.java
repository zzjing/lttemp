
public class CycleHead {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> occur = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!occur.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
