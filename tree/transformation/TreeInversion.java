/**
 * Invert a binary tree around the middle line.
 * i.e. reflect the left and right subtrees around the middle line.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 6, 2016
 */

public class TreeInversion {
    // @param root: a binary tree representation
    // @return: an inverted binary tree
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    // top-down
    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }
}
