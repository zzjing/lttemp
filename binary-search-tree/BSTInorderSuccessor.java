
public class BSTInorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // i.e. find the smallest node value that is bigger than p's
        if (root == null) {
            return null;
        }
        // root cannot be p's inorder successor;
        // neither can any node within its left subtree
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else { // attempt to continue searching toward the left
            // b/c root or a node in its left subtree is its successor
            TreeNode leftSubtree = inorderSuccessor(root.left, p);
            if (leftSubtree != null) { // left subtree is not null, search left
                return leftSubtree;
            } else {
                return root; // otherwise it is just the root
            }
        }
    }
}
