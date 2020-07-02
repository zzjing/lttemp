
public class LeftmostLeaf {
    int maxDepth;
    int leftVal;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        maxDepth = 0;
        leftVal = root.val;
        findBottomLeftValue(root, 0);
        return leftVal;
    }

    private void findBottomLeftValue(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        // reaches a leaf node
        if (root.left == null && root.right == null && curDepth > maxDepth) {
            maxDepth = curDepth;
            leftVal = root.val;
        }
        findBottomLeftValue(root.left, curDepth + 1);
        findBottomLeftValue(root.right, curDepth + 1);
    }
}
