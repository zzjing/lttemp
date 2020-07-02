import java.util.HashSet;
import java.util.Set;

public class ListsIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodeSaver = new HashSet<ListNode>();
        ListNode current = headA;
        while (current != null) {
            nodeSaver.add(current);
            current = current.next;
        }
        current = headB;
        while (current != null) {
            if (nodeSaver.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
