
public class TreeNodesLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return null to indicate that p and q are not present in the current subtree
        // or return p or q to indicate that p or q is present in the current subtree
        // special case: if a node is the ancestor of the other, return LCA -- the node
        if (root == null || root == p || root == q) {
            return root;
        }
        // Look for p and q in left and right subtrees
        // also avoids null-pointer error
        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);
        // p and q are located separately in the left and right subtrees
        if (leftSubtree != null && rightSubtree != null) {
            return root;
        }
        // both nodes are located within the leftsubtree (pass it on)
        if (leftSubtree != null) {
            return leftSubtree;
        } else { // within the right subtree
            return rightSubtree;
        }
    }
}
