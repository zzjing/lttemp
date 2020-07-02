/**
 * Check if two binary trees are essentially the same tree.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 3, 2016
 */

public class SameTreeCheck {
    // recursive method, top-down
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base cases
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        // alternatively, return p == q to eliminate above lines but less readable
        } else if (p.val != q.val) {
            return false;
        }
        // check left subtrees and right subtrees, respectively
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
