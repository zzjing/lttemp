
public class BSTClosestValue {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return (int) target;
        }
        return closestValue(root, target, root.val);
    }

    private int closestValue(TreeNode root, double target, int closest) {
        // reaches the bottom of a branch
        if (root == null) {
            return closest;
        }
        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        // no else if should be used here b/c we continue to traverse down
        if (root.val > target) {
            closest = closestValue(root.left, target, closest);
        }
        if (root.val < target) {
            closest = closestValue(root.right, target, closest);
        }
        return closest;
    }
}
