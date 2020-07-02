
public class ListReorder {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode preMiddle = null;
        ListNode l1 = head;
        while (fast != null && fast.next != null) {
            preMiddle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // guaranteed even number of nodes, slow is after the middle
        preMiddle.next = null; // cut
        ListNode l2 = reverse(slow);
        reorder(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void reorder(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            if (l1Next == null) {
                break; // merge is complate
            }
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
