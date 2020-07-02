
public class TreeToStrConversion {
    public String treeTostr(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        treeTostr(root, sb);
        return sb.toString();
    }

    private void treeTostr(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val); // a lone parent
            // the parent has at least one child
            if (root.left != null || root.right != null) {
                sb.append("(");
                treeTostr(root.left, sb);
                sb.append(")");
                // traverse toward right if there is a right child
                // otherwise skip and do nothing
                if (root.right != null) {
                    sb.append("(");
                    treeTostr(root.right, sb);
                    sb.append(")");
                }
            }
        }
    }
    // alternative solution; recursively handle different cases 
    /* public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        } else if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    } */
}
