import java.util.Stack;

public class ListNumAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> digit1 = new Stack<>();
        Stack<Integer> digit2 = new Stack<>();
        while (l1 != null) {
            digit1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            digit2.push(l2.val);
            l2 = l2.next;
        }
        int digitSum = 0;
        ListNode curDigit = new ListNode(0);
        while (!digit1.isEmpty() || !digit2.isEmpty()) {
            if (!digit1.isEmpty()) {
                digitSum += digit1.pop();
            }
            if (!digit2.isEmpty()) {
                digitSum += digit2.pop();
            }
            curDigit.val = digitSum % 10;
            digitSum /= 10;
            ListNode nextHead = new ListNode(digitSum);
            nextHead.next = curDigit;
            curDigit = nextHead;
        }
        if (curDigit.val == 0) {
            return curDigit.next;
        }
        return curDigit;
    }
}
