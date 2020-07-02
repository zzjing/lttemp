
public class BSTvalidation {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    private boolean isValidBST(TreeNode root, double upperBound, double lowerBound) {
        if (root == null) {
            return true;
        }
        if (root.val >= upperBound || root.val <= lowerBound) {
            return false;
        }
        return isValidBST(root.left, root.val, lowerBound) && isValidBST(root.right, upperBound, root.val);
    }
}
