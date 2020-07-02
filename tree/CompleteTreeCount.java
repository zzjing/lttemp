
public class CompleteTreeCount {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }

    private int rightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
