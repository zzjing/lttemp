/**
 * Merges k (integers) sorted linked lists as a single
 * sorted linked list.
 * 
 * @author Zezhou Jing, University of Washington
 * @date September 5, 2016
 */
public class SortedListsMerge {
    // divide & conquer solution by continuously partitioning the list
    // around the pivot element in its middle
    // Time complexity O(nk log n); space O(1)
    public ListNode mergeLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    // helper method to divide (partition) the list into halves
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        // finds the middle pivot s.t. the list can be partitioned
        int midPivot = start + (end - start) / 2;
        // "divide" step; partition the list
        ListNode left = merge(lists, start, midPivot);
        ListNode right = merge(lists, midPivot + 1, end);
        // "conquer" step
        return mergeTwo(left, right);
    }

    // merges (conquers) two sublists by splicing together the nodes of two sublists
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        // boundary cases
        if (l1 == null && l2 == null) {
            return null;
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current  = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else { // assume that they are never equal in value
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return dummy.next;
    }
}
