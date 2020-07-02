import java.util.ArrayList;
import java.util.List;

public class TreePaths {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<String>();
        if (root == null) {
            return allPaths;
        }
        findPath(root, String.valueOf(root.val), allPaths);
        return allPaths;
    }

    private void findPath(TreeNode root, String path, List<String> allPaths) {
        // base case, nothing to construct
        if (root == null) {
            return;
        }
        // at the bottom, this is a path
        if (root.left == null && root.right == null) {
            allPaths.add(path);
            return;
        }
        // find paths of the left subtrees
        if (root.left != null) {
            findPath(root.left, path + "->" + String.valueOf(root.left.val), allPaths);
        }
        // find paths of the right subtrees
        if (root.right != null) {
            findPath(root.right, path + "->" + String.valueOf(root.right.val), allPaths);
        }
    }
}
