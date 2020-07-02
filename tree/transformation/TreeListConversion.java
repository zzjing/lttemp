
public class TreeListConversion {
    // reverse pre-order construction: top-down
    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode root, TreeNode next) {
        // 'next' in the sense of the next node in a linkedlist
        // it actually comes from the last layer of recursion
        if (root == null) {
            return next;
        }
        next = flatten(root.right, next);
        next = flatten(root.left, next);
        root.left = null;
        root.right = next;
        next = root;
        return next;
    }

    // pre-order construction: top-down
    private TreeNode tail = null;
    public void treeToList(TreeNode root) {
        // * Use a picture to do recursive tracing
        // Keep track on the tail of the current linked list
        // Base case: at the bottom of the tree
        if (root == null) {
            return;
        }
        if (tail != null) {
            // remove the pointer pointing to the left
            tail.left = null;
            // move the right pointer such that it points
            // to elements of preorder (e.g. left subtree)
            tail.right = root;
        }
        // pass on, move lastNode cursor to the next node to flatten
        tail = root;
        // store the right subtrees (cannot lose it)
        TreeNode rightSub = root.right;
        // flatten left and then right
        treeToList(root.left);
        treeToList(rightSub);
    }
}
