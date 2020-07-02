
public class DuplicateNodeRemover {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteAllDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            // case 1: we have not removed any duplicates (in the last step)
            if (prev.next == current) {
                prev = prev.next;
            } else { // case 2: we have removed every duplicate except for the last one
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
