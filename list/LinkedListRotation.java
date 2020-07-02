
public class LinkedListRotation {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        int length = 0;
        // count the number of nodes in the list
        while (fast.next != null) {
            length++;
            fast = fast.next;
        }
        ListNode slow = dummy;
        // move the slower pointer, handle the case k > length
        for (int i = 0; i < length - k % length; i++) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
