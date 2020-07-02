
public class LinkedListReversal {
    // Iterative solution; Time complexity O(n), space O(1).
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode revHead = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = revHead;
            revHead = current;
            current = next;
        }
        return revHead;
    }

    // Recursive solution; Time complexity O(n), space O(n).
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = reverseList(head.next);
        // reverse the current node
        head.next.next = head;
        // dereference the front pointer to the current head
        head.next = null;
        // return the front
        return current;
    }
}
