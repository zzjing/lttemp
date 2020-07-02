
public class ListNumAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode sum = new ListNode(-1);
        ListNode current = sum;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int digitSum = 0;
        while (c1 != null || c2 != null) {
            if (c1 != null) {
                digitSum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                digitSum += c2.val;
                c2 = c2.next;
            }
            current.next = new ListNode(digitSum % 10);
            current = current.next;
            digitSum /= 10;
        }
        if (digitSum != 0) {
            current.next = new ListNode(digitSum);
        }
        return sum.next;
    }
}
