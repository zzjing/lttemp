/**
 * Merge k (integer) sorted linked lists as a single
 * sorted linked list.
 * 
 * @author Zezhou Jing, University of Washington
 * @date September 5, 2016
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class KsortedListsMerge {
    // Heap, or priority queue solution.
    // Time complexity O(nk); space O(k).
    public ListNode mergeLists(ListNode[] lists) {
        // Simple boundary cases
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, NodeComparator);
        // Add all listNodes to the heap
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        // Pull all listNodes from the heap
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!heap.isEmpty()) {
            ListNode nextNode = heap.poll();
            current.next = nextNode;
            current = nextNode;
            if (nextNode.next != null) {
                heap.add(nextNode.next);
            }
        }
        return dummy.next;
    }

    // Implement a comparator such that all nodes are now comparable
    private Comparator<ListNode> NodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode leftHead, ListNode rightHead) {
            if (leftHead == null) {
                return 1;
            } else if (rightHead == null) {
                return -1;
            }
            return leftHead.val - rightHead.val;
        }
    };

    /* Alternate version without using comparator
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = smallest;
            smallest = smallest.next;
            current = current.next;
            if (smallest != null) {
                pq.add(smallest);
            }
        }
        return dummy.next;
    }
    */
}
