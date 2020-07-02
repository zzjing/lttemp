
public class ListNodeSwap {
    /*
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev1 = null;
        ListNode prev2 = null;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == v1) {
                prev1 = current;
            }
            if (current.next.val == v2) {
                prev2 = current;
            }
            current = current.next;
        }
        if (prev1 == null || prev2 == null) {
            return head;
        }
        // if in one case, two nodes stick to each other
        // swap them such that only one corner case is left
        if (prev2.next == prev1) {
            ListNode tmp = prev2;
            prev2 = prev1;
            prev1 = tmp;
        }
        ListNode node1 = prev1.next;
        ListNode node2 = prev2.next;
        ListNode node2Next = node2.next;
        // corner case: swap two consecutive nodes
        if (prev1.next == prev2) {
            node1.next = node2Next;
            prev1.next = node2;
            node2.next = node1;
        } else { // normal cases
            node2.next = node1.next;
            node1.next = node2Next;
            prev1.next = node2;
            prev2.next = node1;
        }
        return dummy.next;
    }
}
