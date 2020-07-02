
public class TreeLCSPath {
    private int longest;
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        if (root == null) {
            return longest;
        }
        findPaths(root);
        return longest;
    }

    private int[] findPaths(TreeNode root) {
        // [0] -> length of an increasing path
        // [1] -> length of a decreasing path
        if (root == null) {
            return new int[]{0, 0};
        }
        // postorder traversal
        int[] leftPaths = findPaths(root.left);
        int[] rightPaths = findPaths(root.right);
        int incPathLen = 1; // a root itself has length of 1
        int decPathLen = 1;
        if (root.left != null) {
            if (root.left.val - root.val == 1) {
                incPathLen = leftPaths[0] + 1;
            } else if (root.val - root.left.val == 1) {
                decPathLen = leftPaths[1] + 1;
            }
        }
        // already have the incPathLen from the left subtree
        // pick the maximum of the two at the root
        // when results are returned bottom-up
        if (root.right != null) {
            if (root.right.val - root.val == 1) {
                incPathLen = Math.max(incPathLen, rightPaths[0] + 1);
            } else if (root.val - root.right.val == 1) {
                decPathLen = Math.max(decPathLen, rightPaths[1] + 1);
            }
        } // count the (subtree) root twice: length = inc + dec - 1 (only possibility)
        longest = Math.max(longest, incPathLen + decPathLen - 1);
        return new int[]{incPathLen, decPathLen};
    }
}
