
public class TreeLongestPath {
    private int maxDm = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return maxDm;
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = getMaxDepth(root.left);
        int rightLen = getMaxDepth(root.right);
        maxDm = Math.max(maxDm, leftLen + rightLen);
        return 1 + Math.max(leftLen, rightLen);
    }
}
