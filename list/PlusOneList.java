
public class PlusOneList {
    public ListNode plusOne(ListNode head) {
        if (compute(head) == 0) {
            return head;
        }
        ListNode newhead = new ListNode(1);
        newhead.next = head;
        return newhead;
    }

    private int compute(ListNode head) {
        if (head == null) {
            return 1;
        }
        int carry = compute(head.next);
        if (carry == 0) {
            return 0;
        }
        int plusOneVal = head.val + 1;
        head.val = plusOneVal % 10;
        return plusOneVal / 10;
    }
}
