
public class BSTLargestSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) {
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isValidBST(TreeNode root, int upperBound, int lowerBound) {
        if (root == null) {
            return true;
        }
        if (root.val >= upperBound || root.val <= lowerBound) {
            return false;
        }
        return isValidBST(root.left, root.val, lowerBound)
            && isValidBST(root.right, upperBound, root.val);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
