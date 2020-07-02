
public class BSTMinGap {
    int minDiff = Integer.MAX_VALUE;
    Integer prev = null;
    // inorder traversal to compare difference between sorted array entries
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minDiff;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        } // guaranteed to be positive
        prev = root.val;
        getMinimumDifference(root.right);
        return minDiff;
    }
}
