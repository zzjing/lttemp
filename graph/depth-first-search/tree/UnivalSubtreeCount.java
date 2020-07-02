
public class UnivalSubtreeCount {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        isCurSubtreeUnival(root, count);
        return count[0];
    }

    private boolean isCurSubtreeUnival(TreeNode root, int[] count) {
        // if current node is null, then the subtree
        // based on the last leaf node is trivially unival
        if (root == null) {
            return true;
        }
        boolean leftSubtree = isCurSubtreeUnival(root.left, count);
        boolean rightSubtree = isCurSubtreeUnival(root.right, count);
        if (leftSubtree && rightSubtree) {
            // current subtree is unival if current root val agrees with
            // left and right values; given that its left and right subtrees
            // are already unival
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            // find a unival subtree rooted upon the current node
            count[0]++; // use an array to avoid scope issues
            return true;
        }
        return false;
    }
}
