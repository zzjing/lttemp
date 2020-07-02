
public class ListBSTconversion {
    private ListNode curNode;
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        curNode = head;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return inorderBuildBST(0, length - 1);
    }

    private TreeNode inorderBuildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode leftSub = inorderBuildBST(start, mid - 1);
        TreeNode curRoot = new TreeNode(curNode.val);
        curRoot.left = leftSub;
        curNode = curNode.next;
        TreeNode rightSub = inorderBuildBST(mid + 1, end);
        curRoot.right = rightSub;
        return curRoot;
    }

    public TreeNode linkedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        } // sitting in the middle of the (sub)list
        TreeNode curRoot = new TreeNode(slow.val);
        curRoot.left = buildBST(head, slow);
        curRoot.right = buildBST(slow.next, tail);
        return curRoot;
    }
}
