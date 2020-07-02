
public class BSTtoGreaterValue {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // reverse inorder traversal
        convertBST(root.right);
        int currentVal = root.val;
        root.val += sum;
        sum += currentVal;
        convertBST(root.left);
        return root;
    }
}
