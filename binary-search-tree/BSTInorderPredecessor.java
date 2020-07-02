
public class BSTInorderPredecessor {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // i.e. find the largest node value that is smaller than p's
        if (root == null) {
            return null;
        }
        if (root.val >= p.val) {
            return inorderPredecessor(root.left, p);
        } else {
            TreeNode rightSubtree = inorderPredecessor(root.right, p);
            if (rightSubtree != null) {
                return rightSubtree;
            } else {
                return root;
            }
        }
    }
}
