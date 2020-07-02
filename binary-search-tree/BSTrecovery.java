
public class BSTrecovery {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorderTraverse(root);
        swap();
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        if (first == null && root.val <= prev.val) {
            first = prev;
        }
        if (first != null && root.val <= prev.val) {
            second = root;
        }
        prev = root;
        inorderTraverse(root.right);
    }

    private void swap() {
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}
