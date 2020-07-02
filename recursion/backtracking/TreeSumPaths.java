import java.util.ArrayList;
import java.util.List;

public class TreeSumPaths {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> validPaths = new ArrayList<>();
        if (root == null) {
            return validPaths;
        }
        pathSum(root, sum, validPaths, new ArrayList<>());
        return validPaths;
    }

    private void pathSum(TreeNode root, int sum,
        List<List<Integer>> validPaths, List<Integer> sumPath) {
        if (root == null) {
            return;
        }
        sumPath.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            validPaths.add(new ArrayList<>(sumPath));
        } else {
            pathSum(root.left, sum - root.val, validPaths, sumPath);
            pathSum(root.right, sum - root.val, validPaths, sumPath);
        }
        sumPath.remove(sumPath.size() - 1);
    }
}
