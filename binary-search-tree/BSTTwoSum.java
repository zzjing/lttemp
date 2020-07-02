
public class BSTTwoSum {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode current, int target) {
        if (current == null) {
            return false;
        }
        return searchTarget(root, current, target - current.val) ||
            dfs(root, current.left, target) || dfs(root, current.right, target);
    }

    private boolean searchTarget(TreeNode root, TreeNode current, int target) {
        if (root == null) {
            return false;
        }
        return ((root.val == target) && (root != current)) ||
            ((root.val < target) && (searchTarget(root.right, current, target))) ||
            ((root.val > target) && (searchTarget(root.left, current, target)));
    }
}
