import java.util.ArrayList;
import java.util.List;

public class TreeBoundary {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<Integer>();
        if (root == null) {
            return boundary;
        }
        boundary.add(root.val);
        if (root.left == null && root.right == null) {
            return boundary;
        }
        getLeftBoundary(root.left, boundary);
        getLeaves(root, boundary);
        getRightBoundary(root.right, boundary);
        return boundary;
    }

    private void getLeftBoundary(TreeNode root, List<Integer> boundary) {
        // required to check if the root is null
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        boundary.add(root.val);
        if (root.left == null) {
            getLeftBoundary(root.right, boundary);
        } else {
            getLeftBoundary(root.left, boundary);
        }
    }

    private void getRightBoundary(TreeNode root, List<Integer> boundary) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right == null) {
            getRightBoundary(root.left, boundary);
        } else {
            getRightBoundary(root.right, boundary);
        }
        boundary.add(root.val);
    }

    private void getLeaves(TreeNode root, List<Integer> boundary) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            boundary.add(root.val);
        }
        getLeaves(root.left, boundary);
        getLeaves(root.right, boundary);
    }
}
