
public class TreeMaxSumPath {
    private int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        maxSubtreePath(root);
        return maxPath;
    }

    private int maxSubtreePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // exclude negative paths
        int leftSubSum = Math.max(0, maxSubtreePath(root.left));
        int rightSubSum = Math.max(0, maxSubtreePath(root.right));
        // "bottom-up" step: maxPath is the bigger among the left and right branches
        // *of the current 'root' (node) since we can only traverse up from one branch
        // left + right + node.val < maxValue -> the path doesn't include the parent node
        maxPath = Math.max(maxPath, leftSubMax + rightSubMax + root.val);
        // pick a bigger path between the left and right subtrees of the current node
        // connect that path to the current root
        return Math.max(leftSubMax, rightSubMax) + root.val;
    }
}
