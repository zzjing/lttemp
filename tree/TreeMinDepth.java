/**
 * Compute the minimum height (or depth) of a binary tree.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 3, 2016
 */

public class TreeMinDepth {
    // @param root: a binary tree represented by a root node
    // @return: the minimum height of the tree
    public int minDepth(TreeNode root) {
        // an empty tree has no height
        if (root == null) {
            return 0;
        }
        // if left subtree is empty, increase the height count and recurse right
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        // if right subtree is empty, increase the height count and recurse left
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        // otherwise figure out the minimum depth between two subtrees
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> bfsTree = new LinkedList<>();
        bfsTree.offer(root);
        int minDepth = 1;
        while (!bfsTree.isEmpty()) {
            int lvSize = bfsTree.size();
            for (int i = 0; i < lvSize; i++) {
                TreeNode current = bfsTree.poll();
                if (current.left == null && current.right == null) {
                    return minDepth;
                }
                if (current.left != null) {
                    bfsTree.offer(current.left);
                }
                if (current.right != null) {
                    bfsTree.offer(current.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }
}
