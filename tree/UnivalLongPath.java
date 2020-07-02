
public class UnivalLongPath {
    private int longest;
    public int longestUnivaluePath(TreeNode root) {
        longest = 0;
        arrowLength(root);
        return longest;
    }

    private int arrowLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtree = arrowLength(root.left);
        int rightSubtree = arrowLength(root.right);
        int leftLen = 0;
        int rightLen = 0;
        if (root.left != null && root.val == root.left.val) {
            leftLen += leftSubtree + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightLen += rightSubtree + 1;
        }
        longest = Math.max(longest, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }
}
