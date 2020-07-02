
public class BSTMinDistance {
    private Integer prevNode;
    private Integer minGap;
    public int minDiffInBST(TreeNode root) {
        prevNode = null;
        minGap = Integer.MAX_VALUE;
        inorder(root);
        return minGap;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prevNode != null) {
            minGap = Math.min(minGap, root.val - prevNode);
        }
        prevNode = root.val;
        inorder(root.right);
    }
}
