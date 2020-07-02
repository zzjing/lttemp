
public class TreeMinDepth {
    public int minDepth(TreeNode root) {
        // an empty tree has no height
        if (root == null) {
            return 0;
        }
        // if left subtree is empty, increase the height count and recurse right
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        // if right subtree is empty, increase the height count and recurse left
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        // otherwise figure out the minimum depth between two subtrees
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
