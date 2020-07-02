
public class BSTNodesLCA {
    // note that p q nodes are interchangeble since we don't know which is bigger
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else { // root.val > p.val && root.val < q.val
            return root;
        } // root.val < p.val && root.val > q.val impossible
    }
}
