import java.util.Set;
import java.util.TreeSet;

public class TreeSecondMinimum {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Set<Integer> treeVals = new TreeSet<Integer>();
        traverse(root, treeVals);
        int count = 0;
        for (Integer val : treeVals) {
            if (count == 1) {
                return val;
            }
            count++;
        }
        return -1;
    }

    private void traverse(TreeNode root, Set<Integer> treeVals) {
        if (root == null) {
            return;
        }
        treeVals.add(root.val);
        traverse(root.left, treeVals);
        traverse(root.right, treeVals);
    }
}
