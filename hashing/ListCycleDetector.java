/**
 * Check if a linked list has any cycle.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 12, 2016
 */
import java.util.HashSet;
import java.util.Set;

public class ListCycleDetector {
    // HashSet solution (extra space); Time complexity O(n), space O(n).
    // @param head: a linked list represented by a head node
    // @return: true if the list has at least one cycle and false otherwise
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSaver = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            // a cycle exists
            if (nodeSaver.contains(current)) {
                return true;
            }
            // put the node to the set
            nodeSaver.add(current);
            // move on to the next node
            current = current.next;
        }
        // no cycle is detected
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> nodeSaver = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (nodeSaver.contains(current)) {
                return current;
            }
            nodeSaver.add(current);
            current = current.next;
        }
        return null;
    }
}
