
public class PalindromicListCheck {
    public boolean isPalindrome(ListNode head) {
        // trivial cases
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode middle = reverseList(slow);
        ListNode current = head;
        while (middle != null) {
            if (middle.val != current.val) {
                return false;
            }
            current = current.next;
            middle = middle.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
