
public class BSTFlattenning {
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    private TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode flattened = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return flattened;
    }
}
