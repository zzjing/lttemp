import java.util.HashMap;
import java.util.Map;

public class TreeEqualSumPartition {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> parentToSubtreesum = new HashMap<Integer, Integer>();
        int treeSum = getSubtreesum(root, parentToSubtreesum);
        if (treeSum == 0) {
            if (!parentToSubtreesum.containsKey(0)) {
                return false;
            }
            // requires two subtrees whose sums are 0 to compose a tree with sum 0
            return parentToSubtreesum.get(0) > 1;
        }
        // a tree can only be partitioned into two equal ones if sum is even
        return treeSum % 2 == 0 && parentToSubtreesum.containsKey(treeSum / 2);
        // check if there is a consecutive subtree whose sum is treeSum / 2
    }

    private int getSubtreesum(TreeNode root, Map<Integer, Integer> parentToSubtreesum) {
        if (root == null) {
            return 0;
        }
        int curSubtreesum = root.val + getSubtreesum(root.left, parentToSubtreesum) +
            getSubtreesum(root.right, parentToSubtreesum);
        if (!parentToSubtreesum.containsKey(curSubtreesum)) {
            parentToSubtreesum.put(curSubtreesum, 1);
        } else {
            parentToSubtreesum.put(curSubtreesum, parentToSubtreesum.get(curSubtreesum) + 1);
        }
        return curSubtreesum;
    }
}
