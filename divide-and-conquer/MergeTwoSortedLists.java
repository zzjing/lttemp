/**
 * Merges two sorted linked lists as a single
 * sorted linked list.
 * 
 * @author Zezhou Jing, University of Washington
 * @date September 5, 2016
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
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
