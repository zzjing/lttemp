/**
 * Compute the maximum height (or depth) of a binary tree.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 3, 2016
 */

public class TreeMaxDepth {
    // @param root: a binary tree represented by a root node
    // @return: the maximum height of the tree
    public int maxDepth(TreeNode root) {
        // an empty tree has no height
        if (root == null) {
            return 0;
        }
        // otherwise figure out the depths of two subtrees
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        }
        List<Integer> childrenHeights = new ArrayList<>();
        for (Node current : root.children) {
            childrenHeights.add(maxDepth(current));
        }
        return 1 + Collections.max(childrenHeights);
    }
}
