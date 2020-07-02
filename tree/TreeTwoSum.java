import java.util.HashSet;
import java.util.Set;

public class TreeTwoSum {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> valSaver = new HashSet<Integer>();
        return findTarget(root, k, valSaver);
    }

    private boolean findTarget(TreeNode root, int target, Set<Integer> valSaver) {
        if (root == null) {
            return false;
        }
        if (valSaver.contains(target - root.val)) {
            return true;
        }
        valSaver.add(root.val);
        return findTarget(root.left, target, valSaver) || findTarget(root.right, target, valSaver);
    }
}
