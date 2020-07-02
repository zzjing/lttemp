
public class TreesMerge {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode tOneLeft = null;
        TreeNode tOneRight = null;
        TreeNode tTwoLeft = null;
        TreeNode tTwoRight = null;
        int curVal = 0;
        if (t1 != null) {
            curVal += t1.val;
            tOneLeft = t1.left;
            tOneRight = t1.right;
        }
        if (t2 != null) {
            curVal += t2.val;
            tTwoLeft = t2.left;
            tTwoRight = t2.right;
        }
        TreeNode newNode = new TreeNode(curVal);
        newNode.left = mergeTrees(tOneLeft, tTwoLeft);
        newNode.right = mergeTrees(tOneRight, tTwoRight);
        return newNode;
    }
    /*
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
    */
}
