
public class TreeCloning {
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode cloneRoot = new TreeNode(root.val);
        cloneRoot.left = cloneTree(root.left);
        cloneRoot.right = cloneTree(root.right);
        return cloneRoot;
    }
}
