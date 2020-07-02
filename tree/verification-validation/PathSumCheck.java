/**
 * Check whether there is a path in a binary tree that adds up to a given sum.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 5, 2016
 */

public class PathSumCheck {
    // @param root: an integer binary tree represented by a root node
    // @param sum: the sum that a path may add up
    // @return: whether there is a path sum
    public boolean hasPath(TreeNode root, int sum) {
        // the end of a tree but still cannot find a path
        if (root == null) {
            return false;
        }
        sum -= root.val;
        // at the bottom of a tree, check if a path adds up to the sum
        if (root.left == null && root.right == null) {
            return (sum == 0);
        }
        // otherwise traverse down to the bottom
        return hasPath(root.left, sum) || hasPath(root.right, sum);
    }
}
