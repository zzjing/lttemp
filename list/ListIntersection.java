
public class ListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        // let c be the length of intersection
        // a be the length of headA with intersection excluded; b likewise
        // after e.g. two iterations, A travels a + c + b + c steps
        // B travels b + c + a + c steps...
        // eventually they meet after a + c + b(b + c + a) steps
        // if c = 0 (no intersection) -- meet at the end (null)
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }
            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }
}
