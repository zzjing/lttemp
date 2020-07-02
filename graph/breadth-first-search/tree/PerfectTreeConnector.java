
public class PerfectTreeConnector {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode current = levelStart;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.next != null && current.right != null) {
                    current.right.next = current.next.left;
                }
                // we will always have a path (.next) below the root
                // because we have connected the current path from level above
                current = current.next;
            }
            levelStart = levelStart.left;
        }
    }
}
