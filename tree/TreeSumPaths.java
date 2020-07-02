import java.util.ArrayList;
import java.util.List;

public class TreeSumPaths {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> validPaths = new ArrayList<List<Integer>>();
        if (root == null) {
            return validPaths;
        }
        pathSum(root, sum, validPaths, new ArrayList<Integer>());
        return validPaths;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> validPaths, List<Integer> path) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                path.add(root.val);
                validPaths.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        pathSum(root.left, sum, validPaths, path);
        pathSum(root.right, sum, validPaths, path);
        path.remove(path.size() - 1);
    }
}
